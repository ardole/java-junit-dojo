package fr.dojo.repository;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;

public interface UserRepository {

    User findUser(String userName) throws UserException;

    void updatePassword(String userName, String newPassword) throws UserException;
}
