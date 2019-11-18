package app.utils;

import app.enties.User;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class DBHelper {

    public static Configuration getConfiguration() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class);
    }

    public static Connection getConnection() {
        return ConnectionProvider.getMysqlConnection();
    }
}
