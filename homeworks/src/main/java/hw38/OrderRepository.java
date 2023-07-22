package hw38;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
    }

    public Order getOrderById(final Long id) {
        Objects.requireNonNull(id);
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .get();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order addOrder(final Order order) {
        Objects.requireNonNull(order);
        orders.add(order);
        return order;
    }
}
