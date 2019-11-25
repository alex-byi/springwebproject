package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.UserDao;
import by.htp.jd2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlUserDao implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").setFirstResult(4 * (page - 1)).setMaxResults(4).list();
    }

    @Override
    public int userCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from User", Number.class).getSingleResult().intValue();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUser(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where login = :paramName");
        query.setParameter("paramName", login);
        return (User) query.getSingleResult();
    }

    @Override
    public void changeRole(User user) {
        Session session = sessionFactory.getCurrentSession();
        if (user.getRole().equals("ADMIN")) {
            user.setRole("USER");
            session.update(user);
        } else if (user.getRole().equals("USER")) {
            user.setRole("ADMIN");
            session.update(user);
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id = :paramName");
        query.setParameter("paramName", id);
        return (User) query.getSingleResult();
    }

    @Override
    public void changeActivity(User user) {
        Session session = sessionFactory.getCurrentSession();
        if (user.isActive()){
            user.setActive(false);
            session.update(user);
        } else if (!user.isActive()){
            user.setActive(true);
            session.update(user);
        }
    }

    @Override
    public void addCash(User user, int cash) {
        Session session = sessionFactory.getCurrentSession();
        user.setCash(user.getCash()+cash);
        session.update(user);
    }

    @Override
    public void changeEmail(User user, String email) {
        Session session = sessionFactory.getCurrentSession();
        user.setEmail(email);
        session.update(user);
    }

    @Override
    public void changePassword(User user, String password) {
        Session session = sessionFactory.getCurrentSession();
        user.setPassword(password);
        session.update(user);
    }
}
