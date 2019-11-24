package by.htp.jd2.service.impl;

import by.htp.jd2.dao.UserDao;
import by.htp.jd2.entity.User;
import by.htp.jd2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers(int page) {
        return userDao.getAllUsers(page);
    }

    @Override
    @Transactional
    public int userCount() {
        return userDao.userCount();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(String login) {
        return userDao.getUser(login);
    }

    @Override
    @Transactional
    public void changeRole(User user) {
        userDao.changeRole(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void changeActivity(User user) {
        userDao.changeActivity(user);
    }

    @Override
    @Transactional
    public void addCash(User user, int cash) {
        userDao.addCash(user,cash);
    }

}
