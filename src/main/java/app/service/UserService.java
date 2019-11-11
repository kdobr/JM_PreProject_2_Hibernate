package app.service;

import app.dao.UserDAO;
import app.enties.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/db_example?serverTimezone=UTC&useSSL=false", "root", "1234");
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDAO getUserDAO() {
        return new UserDAO(getMysqlConnection());
    }

    public boolean addUser(User user) throws SQLException {
        if (getUserDAO().getUserByLogin(user.getLogin()) != null) {
            return false;
        }
        getUserDAO().addUser(user);
        return true;
    }

    public User getUser(String login, String password) throws SQLException {
        if (getUserDAO().validateUser(login, password)) {
            User user = getUserDAO().getUserByLogin(login);
            return user;
        }
        return null;
    }

    public boolean updateUser(User user) throws SQLException {
        if (getUserDAO().validateUser(user.getLogin(), user.getPassword())) {
            getUserDAO().updateUser(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String login, String password) throws SQLException {
        if (getUserDAO().validateUser(login, password)) {
            getUserDAO().deleteUser(login);
            return true;
        }
        return false;
    }

    public List<User> getUsersList() throws SQLException {
        return getUserDAO().getAllUsers();
    }


}
