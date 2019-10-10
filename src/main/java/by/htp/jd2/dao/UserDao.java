package by.htp.jd2.dao;

import by.htp.jd2.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers(int page);
    int userCount();
    void addUser(User user);
    User getUser(String login);
}
