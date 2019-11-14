package app.service;

import app.dao.UserDAO;
import app.enties.User;

import java.sql.Connection;
import java.util.List;

public class UserService implements IUserServise {

    private static UserDAO userDAO;
    private static UserService userService;

    private UserService(Connection connection) {
        userDAO = new UserDAO(connection);
    }


    public static UserService getUserService(Connection connection) {
        if (userService == null) {
            userService = new UserService(connection);
        }
        return userService;
    }

    @Override
    public boolean addUser(User user) {
        if (userDAO.getUserByLogin(user.getLogin()) != null) {
            return false;
        }
        userDAO.addUser(user);
        return true;
    }

    @Override
    public User getUser(String login, String password) {
        if (userDAO.validateUser(login, password)) {
            return userDAO.getUserByLogin(login);
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        if (userDAO.validateUser(user.getLogin(), user.getPassword())) {
            userDAO.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String login, String password) {
        if (userDAO.validateUser(login, password)) {
            userDAO.deleteUser(login);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUsersList() {
        return userDAO.getAllUsers();
    }


}
