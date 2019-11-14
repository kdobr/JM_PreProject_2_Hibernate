package app.service;

import app.dao.UserDAO;
import app.enties.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserServise {



    public boolean addUser(User user) throws SQLException;

    public User getUser(String login, String password) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public boolean deleteUser(String login, String password) throws SQLException;

    public List<User> getUsersList() throws SQLException;

}
