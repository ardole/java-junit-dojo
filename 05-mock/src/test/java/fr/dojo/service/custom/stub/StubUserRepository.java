package fr.dojo.service.custom.stub;

import fr.dojo.model.User;
import fr.dojo.repository.UserRepository;

public class StubUserRepository implements UserRepository {

    @Override
    public User findUser(String userName) {
        User user = new User();
        user.setPassword("1234");
        user.setUserName(userName);
        return user;
    }

    @Override
    public void updatePassword(String userName, String newPassword) {
        /* Do nothing */
    }

}
