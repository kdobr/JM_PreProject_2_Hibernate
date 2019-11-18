package app.service;

import app.dao.DAO_Factory;
import app.dao.UserDAO;
import app.enties.User;
import app.utils.PropertyReaderHelper;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDAO userDAO;
    private static UserServiceImpl userService;

        private UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            String daoType = new PropertyReaderHelper().getProperty("typeDAO");
            UserDAO userDAO = DAO_Factory.getUserDAO(daoType);
            userService = new UserServiceImpl(userDAO);
        }
        return userService;
    }

        @Override
        public boolean addUser (User user){
            if (userDAO.getUserByLogin(user.getLogin()) != null) {
                return false;
            }
            userDAO.addUser(user);
            return true;
        }

        @Override
        public boolean updateUser (User user, String password){
            if (userDAO.validateUser(user.getLogin(), password)) {
                userDAO.updateUser(user);
                return true;
            }
            return false;
        }

        @Override
        public void deleteUser (String login){
            userDAO.deleteUser(login);
        }

        @Override
        public List<User> getUsersList () {
            return userDAO.getAllUsers();
        }
    }
