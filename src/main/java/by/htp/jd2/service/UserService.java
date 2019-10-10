package by.htp.jd2.service;

import by.htp.jd2.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers(int page);
    int userCount();
    void addUser(User user);
    User getUser(String login);
}
