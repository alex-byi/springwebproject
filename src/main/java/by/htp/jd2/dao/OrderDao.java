package by.htp.jd2.dao;

import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;
import by.htp.jd2.entity.User;

import java.util.List;

public interface OrderDao {

    List<Order> getAllOrders(int page);

    int orderCount();

    void completeOrder(Order order);

    void cancelOrder(Order order, String reason);

    Order getOrderById(int id);

    void setCrash(Order order, Crash crash);

    List<Order> getUserOrders(int userId, int page);

    int userOrderCount(int userId);

}
