package app.dao;

import app.utils.DBHelper;

public class DAO_Factory {
    public static UserDAO getUserDAO(String daoType) {
        UserDAO userDAO = null;
        if (daoType.equals("hibernate")) {
            userDAO = new UserDAOHibernateImpl(DBHelper.getConfiguration().buildSessionFactory());
        } else if (daoType.equals("jdbc")) {
            userDAO = new UserDAOjdbcImpl(DBHelper.getConnection());
        }
        return userDAO;
    }
}
