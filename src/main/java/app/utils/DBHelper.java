package app.utils;

import app.enties.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHelper {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory createSessionFactory() {

        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
