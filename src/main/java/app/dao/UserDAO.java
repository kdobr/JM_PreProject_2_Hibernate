package app.dao;

import app.enties.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;
    private Executor executor;

    public UserDAO(Connection connection) {
        this.connection = connection;
        executor = new Executor(connection);
    }

    public boolean validateUser(String login, String password) throws SQLException {
        User user = getUserByLogin(login);
        if (user != null) {
            return getUserByLogin(login).getPassword().equals(password);
        } else return false;
    }

    public User getUserByLogin(String login) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "'", result -> {
            if (result.next()){
                return new User(result.getString("login"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getDouble("amount"));} else {
                return null;
            }

        });
    }

    public void addUser(User user) throws SQLException {
        executor.execUpdate("insert into users (login, password, name, amount) values ('" + user.getLogin() + "', '" +
                user.getPassword() + "', '" + user.getName() + "', '" + user.getAmount() + "')");
    }

    public boolean deleteUser(String login) {
        try {
            executor.execUpdate("delete from users where login='" + login + "';");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void updateUser(User user) throws SQLException {
        String newName = user.getName();
        double newAmount = user.getAmount();
        String sql = "update users set name=?, amount=? where login=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, newName);
        stmt.setDouble(2, newAmount);
        stmt.setString(3, user.getLogin());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        return executor.execQuery("select * from users", result -> {
            List<User> usersList = new ArrayList<>();
            while (result.next()) {
                usersList.add(new User(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4)));
            }
            return usersList;
        });
    }
}
