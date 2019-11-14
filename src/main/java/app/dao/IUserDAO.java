package app.dao;

import app.enties.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IUserDAO {

    public boolean validateUser(String login, String password) throws SQLException;

    public User getUserByLogin(String login) throws SQLException;

    public void addUser(User user) throws SQLException;

    public boolean deleteUser(String login);

    public void updateUser(User user) throws SQLException;

    public List<User> getAllUsers() throws SQLException;

}
