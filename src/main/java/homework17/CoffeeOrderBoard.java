package homework17;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeeOrderBoard {
    private Map<Integer, Order> orderMap = new HashMap<>();
    private int orderNumber;
    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    public void add(String customerName) {
        Objects.requireNonNull(customerName);
        orderMap.put(++orderNumber, new Order(orderNumber, customerName));
        LOGGER.info("Added order: OrderNumber={}, CustomerName={}", orderNumber, customerName);
    }

    public void deliver() {
        if (!orderMap.isEmpty()) {
            orderMap.remove(orderMap.keySet().iterator().next());
            LOGGER.info("Delivered order: OrderNumber={}", orderNumber);
        } else {
            String errorMessage = "You don't have any orders to deliver!";
            LOGGER.error("Can't deliver non-exist order: OrderNumber={}, \n {}", orderNumber, errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void deliver(int orderNumber) {
        if (orderNumber >= 0 && orderMap.containsKey(orderNumber)) {
            orderMap.remove(orderNumber);
            LOGGER.info("Delivered order: OrderNumber={}", orderNumber);
        } else {
            String errorMessage = "Wrong order number!";
            LOGGER.error("Can't deliver non-exist order: OrderNumber={}, \n {}", orderNumber, errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public String draw() {
        StringBuilder orderTable = new StringBuilder();
        orderTable.append("Num | Name\n");
        for (Order order : new ArrayList<>(orderMap.values())) {
            orderTable.append(String.format("%-3d | %s%n", order.getOrderNumber(), order.getCustomerName()));
        }
        LOGGER.info("Drawing order board");
        return orderTable.toString();
    }
}
