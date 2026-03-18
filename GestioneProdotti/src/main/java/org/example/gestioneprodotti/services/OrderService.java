package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.Order;
import org.example.gestioneprodotti.models.Product;
import org.example.gestioneprodotti.models.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, List<Product> products);
    public List<Order> getOrders();
    public List<Order> getOrdersByUser(Long id);
    public Order getOrderById(Long id);
    public Order saveOrder(Order order);
    public Order cacelOrder(Long id);

}
