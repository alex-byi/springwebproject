package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.CarDao;
import by.htp.jd2.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public int carCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Car", Number.class).getSingleResult().intValue();
    }

    @Override
    public Car getCarById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Car where id = :paramName");
        query.setParameter("paramName", id);
        return (Car) query.getSingleResult();
    }

    @Override
    public boolean deactivateCar(Car car) {
        Session session = sessionFactory.getCurrentSession();
        car.setActive(false);
        session.update(car);
        return true;
    }

    @Override
    public boolean activateCar(Car car) {
        Session session = sessionFactory.getCurrentSession();
        car.setActive(true);
        session.update(car);
        return true;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllAvailableCars(String startDate, String endDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select * from cars where idcars NOT IN (select cars_idcars from orders " +
                "where (enddate > :paramName1) OR ((startdate > :paramName2) AND (startdate < :paramName3)))").addEntity(Car.class);
        query.setParameter("paramName1", startDate);
        query.setParameter("paramName2", startDate);
        query.setParameter("paramName3", endDate);
        return query.list();
    }
}
