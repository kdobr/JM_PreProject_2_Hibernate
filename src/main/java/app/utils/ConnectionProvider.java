package app.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {

    public static Connection getMysqlConnection() {
        try {
PropertyReaderHelper rh = new PropertyReaderHelper();
            StringBuilder url = new StringBuilder();
            url.append("jdbc:")
                    .append(rh.getProperty("jdbcDriver")+"://")
                    .append(rh.getProperty("serverName") + ":")
                    .append(rh.getProperty("port") + "/")
                    .append(rh.getProperty("dataBaseName") + "?")
                    .append("serverTimezone=" + rh.getProperty("serverTimezone"))
                    .append("&useSSL=" + rh.getProperty("useSSL"));
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            return DriverManager.getConnection(url.toString(), rh.getProperty("user"), rh.getProperty("password"));
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
