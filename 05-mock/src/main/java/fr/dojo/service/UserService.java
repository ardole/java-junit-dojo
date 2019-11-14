package fr.dojo.service;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;
import fr.dojo.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void changeUserPassword(String userName, String newPassword) throws UserException {
        try {
            User user = userRepository.findUser(userName);
            String oldPassword = user.getPassword();
            if (oldPassword.equals(newPassword)) {
                throw new UserException("New password should be different from the old one !");
            } else {
                userRepository.updatePassword(userName, newPassword);
            }
        } catch (UserException exception) {
            throw exception;
        } catch (Exception anyOtherException) {
            throw new UserException("Unable to change user password.", anyOtherException);
        }
    }

}
