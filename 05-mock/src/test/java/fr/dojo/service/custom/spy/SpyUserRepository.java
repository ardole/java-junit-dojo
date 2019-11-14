package fr.dojo.service.custom.spy;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;
import fr.dojo.repository.UserRepository;

public class SpyUserRepository implements UserRepository {

    private boolean passwordHasBeenUpdated;
    private String updatedPasswordValue;

    boolean passwordHasBeenUpdated() {
        return passwordHasBeenUpdated;
    }

    String getUpdatedPasswordValue() {
        return updatedPasswordValue;
    }

    @Override
    public User findUser(String userName) {
        User user = new User();
        user.setPassword("1234");
        user.setUserName(userName);
        return user;
    }

    @Override
    public void updatePassword(String userName, String newPassword) throws UserException {
        this.passwordHasBeenUpdated = true;
        this.updatedPasswordValue = newPassword;
    }

}
