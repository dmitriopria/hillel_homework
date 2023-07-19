package hw38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final Long id) {
        Order order = orderRepository.getOrderById(id);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody final Order order) {
        Order addedOrder = orderRepository.addOrder(order);
        return ResponseEntity.ok().body(addedOrder);
    }
}
