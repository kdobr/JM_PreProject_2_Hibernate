package app.dao;

import app.enties.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {

    private SessionFactory factory;

    public UserDAOHibernateImpl(SessionFactory factory) {
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
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

        } catch (RuntimeException e) {
            try {
                transaction.rollback();
                printTransactionError();
            } catch (Exception eRoll) {
                printRollBackError();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void deleteUser(String login) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            User user = getUserByLogin(login);
            session.delete(user);
            transaction.commit();
        } catch (RuntimeException e) {
            try {
                transaction.rollback();
                printTransactionError();
            } catch (Exception eRoll) {
                printRollBackError();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (RuntimeException e) {
            try {
                transaction.rollback();
                printTransactionError();
            } catch (Exception eRoll) {
                printRollBackError();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) factory.openSession().createQuery("From User").getResultList();
    }

    private void printRollBackError() {
        System.err.println("Couldn’t roll back transaction");
    }

    private void printTransactionError() {
        System.err.println("Error occured, transaction rolled back");
    }
}
