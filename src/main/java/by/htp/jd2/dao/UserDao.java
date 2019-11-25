package by.htp.jd2.dao;

import by.htp.jd2.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers(int page);

    int userCount();

    void addUser(User user);

    User getUser(String login);

    void changeRole(User user);

    User getUserById(int id);

    void changeActivity(User user);

    void addCash(User user, int cash);

    void  changeEmail(User user, String email);

    void  changePassword(User user, String password);
}
