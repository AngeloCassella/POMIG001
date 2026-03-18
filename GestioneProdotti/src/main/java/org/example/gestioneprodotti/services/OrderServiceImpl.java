package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.Order;
import org.example.gestioneprodotti.models.Product;
import org.example.gestioneprodotti.models.StatusOrder;
import org.example.gestioneprodotti.models.User;
import org.example.gestioneprodotti.repositories.OrderRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired @Qualifier("createOrder") ObjectProvider<Order> createOrderProvider;
    @Autowired OrderRepository orderRepository;

    @Override
    public Order createOrder(User user, List<Product> products) {
        double totalPrice = products.stream()
                                    .mapToDouble(product -> product.getPrice().doubleValue())
                                    .sum();
        Order order = createOrderProvider.getObject();
        order.setUser(user);
        order.setProducts(products);
        order.setStatus(StatusOrder.PENDING);
        order.setTotalPrice(BigDecimal.valueOf(totalPrice));
        return order;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUser(Long id) {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().filter(o -> o.getUser().getId() == id).toList();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order saveOrder(Order order) {
        double totalPrice = order.getProducts().stream()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .sum();
        order.setTotalPrice(BigDecimal.valueOf(totalPrice));
        order.setStatus(StatusOrder.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order cacelOrder(Long id) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(StatusOrder.CANCELLED);
        return orderRepository.save(order);
    }
}
