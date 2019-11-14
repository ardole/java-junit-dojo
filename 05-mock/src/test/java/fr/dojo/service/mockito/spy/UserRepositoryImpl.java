package fr.dojo.service.mockito.spy;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;
import fr.dojo.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findUser(String userName) throws UserException {
        User user = new User();
        user.setPassword("1234");
        user.setUserName(userName);
        return user;
    }

    @Override
    public void updatePassword(String userName, String newPassword) throws UserException {
        /* Do nothing */
    }

}
