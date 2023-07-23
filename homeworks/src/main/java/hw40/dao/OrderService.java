package hw40.dao;

import hw40.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order getOrderById(final Long id) {
        validateOrderId(id);
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order addOrder(final Order order) {
        return orderRepository.save(Objects.requireNonNull(order));
    }

    @Transactional
    public void deleteOrder(final Order order) {
        orderRepository.delete(Objects.requireNonNull(order));
    }

    public Order getOrderWithRelatedProducts(final Long orderId) {
        validateOrderId(orderId);
        return orderRepository.findByIdWithRelatedProducts(orderId);
    }

    private void validateOrderId(Long id) {
        Objects.requireNonNull(id);
        if (id <= 0) {
            throw new RuntimeException("Order ID mustn't be 0 or negative");
        }
    }
}
