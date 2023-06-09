package hw31;

import hw31.entity.Order;
import hw31.entity.Product;
import hw31.exception.JdbcOperationException;
import hw31.jdbc.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = Objects.requireNonNull(orderRepository);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order;
        if (id < 1) {
            throw new JdbcOperationException("Order id can't be negative or zero!");
        } else order = orderRepository.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody Product product) {
        orderRepository.addOrder(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
