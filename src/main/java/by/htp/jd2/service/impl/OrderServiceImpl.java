package by.htp.jd2.service.impl;

import by.htp.jd2.dao.OrderDao;
import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;
import by.htp.jd2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public List<Order> getAllOrders(int page) {
        return orderDao.getAllOrders(page);
    }

    @Override
    @Transactional
    public int orderCount() {
        return orderDao.orderCount();
    }

    @Override
    @Transactional
    public void completeOrder(Order order) {
        orderDao.completeOrder(order);
    }

    @Override
    @Transactional
    public void cancelOrder(Order order, String reason) {
        orderDao.cancelOrder(order, reason);
    }

    @Override
    @Transactional
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public void setCrash(Order order, Crash crash) {
        orderDao.setCrash(order, crash);
    }
}
