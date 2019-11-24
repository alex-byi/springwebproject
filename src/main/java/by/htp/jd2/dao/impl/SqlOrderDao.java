package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.OrderDao;
import by.htp.jd2.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlOrderDao implements OrderDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getAllOrders(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order").setFirstResult(4 * (page - 1)).setMaxResults(4).list();
    }

    @Override
    public int orderCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Order", Number.class).getSingleResult().intValue();
    }
}
