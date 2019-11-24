package by.htp.jd2.service;

import by.htp.jd2.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(int page);
    int orderCount();
}
