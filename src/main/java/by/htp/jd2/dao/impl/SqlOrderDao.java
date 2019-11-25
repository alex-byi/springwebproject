package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.OrderDao;
import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Override
    public void completeOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        order.setComplete(true);
        session.update(order);

    }

    @Override
    public void cancelOrder(Order order, String reason) {
        Session session = sessionFactory.getCurrentSession();
        order.setCanceled(true);
        order.setRejectReason(reason);
        session.update(order);
    }

    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Order where id = :paramName");
        query.setParameter("paramName", id);
        return (Order) query.getSingleResult();
    }

    @Override
    public void setCrash(Order order, Crash crash) {
        Session session = sessionFactory.getCurrentSession();
        order.setCrash(true);
        order.setCrashBill(crash.getId());
        session.update(order);
    }

    @Override
    public int userOrderCount(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Order where idUser = :paramName", Number.class)
                .setParameter("paramName", userId).getSingleResult().intValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getUserOrders(int userId, int page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Order where idUser = :paramName").setFirstResult(4 * (page - 1)).setMaxResults(4);
        query.setParameter("paramName", userId);
        return query.list();
    }

}
