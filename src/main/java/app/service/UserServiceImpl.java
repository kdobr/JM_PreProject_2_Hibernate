package app.service;

import app.dao.UserDAO;
import app.dao.UserDAOImpl;
import app.enties.User;
import app.utils.DBHelper;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDAO userDAO;
    private static UserServiceImpl userService;

    private UserServiceImpl(SessionFactory factory) {
        userDAO = new UserDAOImpl(factory);
    }

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(DBHelper.getSessionFactory());
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
    public boolean updateUser(User user, String password) {
        if (userDAO.validateUser(user.getLogin(), password)) {
            userDAO.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(String login) {
        userDAO.deleteUser(login);
    }

    @Override
    public List<User> getUsersList() {
        return userDAO.getAllUsers();
    }


}
