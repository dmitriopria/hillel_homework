package hw39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody final Order order) {
        Order addedOrder = orderService.addOrder(order);
        return ResponseEntity.ok().body(addedOrder);
    }
}
