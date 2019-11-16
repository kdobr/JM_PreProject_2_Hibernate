package app.dao;

import app.enties.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private SessionFactory factory;

    public UserDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean validateUser(String login, String password) {
        User user = getUserByLogin(login);
        if (user != null) {
            return getUserByLogin(login).getPassword().equals(password);
        } else return false;
    }

    @Override
    public User getUserByLogin(String login) {
         return factory.openSession().get(User.class, login);

    }

    @Override
    public void addUser(User user) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteUser(String login) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        User user = getUserByLogin(login);
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)  factory.openSession().createQuery("From User").getResultList();
    }
}
