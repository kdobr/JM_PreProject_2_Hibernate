package app.dao;

import app.enties.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public boolean validateUser(String login, String password);

    public User getUserByLogin(String login);

    public void addUser(User user) ;

    public void deleteUser(String login);

    public void updateUser(User user) ;

    public List<User> getAllUsers() ;

}
