package app.service;

import app.dao.Executor;
import app.dao.UserDAO;
import app.enties.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserListService {

    Executor executor = new Executor(getMysqlConnection());

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





}
