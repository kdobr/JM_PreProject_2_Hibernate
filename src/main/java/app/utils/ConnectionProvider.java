package app.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static app.utils.PropertyReader.getProperty;

public class ConnectionProvider {

    public static Connection getMysqlConnection() {
        try {
            StringBuilder url = new StringBuilder();
            url.append("jdbc:")
                    .append(getProperty("jdbcDriver")+"://")
                    .append(getProperty("serverName") + ":")
                    .append(getProperty("port") + "/")
                    .append(getProperty("dataBaseName") + "?")
                    .append("serverTimezone=" + getProperty("serverTimezone"))
                    .append("&useSSL=" + getProperty("useSSL"));

            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            return DriverManager.getConnection(url.toString(), getProperty("user"), getProperty("password"));
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
