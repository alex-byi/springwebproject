package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.CarDao;
import by.htp.jd2.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlCarDao implements CarDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllCars(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").setFirstResult(4 * (page - 1)).setMaxResults(4).list();
    }

    @Override
    public int carCount(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Car", Number.class).getSingleResult().intValue();
    }
}
