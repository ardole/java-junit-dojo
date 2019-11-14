package fr.dojo.repository;

import fr.dojo.exception.UserException;
import fr.dojo.model.User;

import java.sql.*;

public class DbUserRepository implements UserRepository {

    private String dbUrl = "jdbc:mysql://localhost:3306/";

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public User findUser(String userName) throws UserException {
        try {
            Connection connection = DriverManager.getConnection(this.dbUrl);
            PreparedStatement statement = connection.prepareStatement("select * from Users where username = ?");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("password"));
                user.setUserName(userName);
                return user;
            } else {
                throw new UserException("User " + userName + " does not exists");
            }
        } catch (SQLException e) {
            throw new UserException("Error while executing query", e);
        }
    }

    @Override
    public void updatePassword(String userName, String newPassword) throws UserException {
        try {
            Connection connection = DriverManager.getConnection(this.dbUrl);
            PreparedStatement statement = connection.prepareStatement("update Users set password = ? where username = ?");
            statement.setString(1, newPassword);
            statement.setString(2, userName);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UserException("Error while executing update", e);
        }
    }

}
