package by.htp.jd2.service;

import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders(int page);

    int orderCount();

    void completeOrder(Order order);

    void cancelOrder(Order order, String reason);

    Order getOrderById(int id);

    void setCrash(Order order, Crash crash);
}
