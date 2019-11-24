package by.htp.jd2.dao;

import by.htp.jd2.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders(int page);
    int orderCount();
}
