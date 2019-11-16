package app.service;

import app.enties.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public boolean updateUser(User user, String password);

    public void deleteUser(String login);

    public List<User> getUsersList();

}
