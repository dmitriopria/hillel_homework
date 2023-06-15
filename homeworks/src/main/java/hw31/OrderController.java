package hw31;

import hw31.entity.Order;
import hw31.entity.Product;
import hw31.jdbc.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderRepository.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody Product product) {
        orderRepository.addOrder(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
