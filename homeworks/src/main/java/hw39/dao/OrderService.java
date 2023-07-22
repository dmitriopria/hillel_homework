package hw39.dao;

import hw39.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(final Long id) {
        return orderRepository.findById(Objects.requireNonNull(id)).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(final Order order) {
        return orderRepository.save(Objects.requireNonNull(order));
    }
}
