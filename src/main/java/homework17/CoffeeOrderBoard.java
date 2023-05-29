package homework17;

import java.util.*;

public class CoffeeOrderBoard {
    private Map<Integer, Order> orderMap = new HashMap<>();
    private int orderNumber;

    public void add(String customerName) {
        Objects.requireNonNull(customerName);
        orderMap.put(++orderNumber, new Order(orderNumber, customerName));
    }

    public void deliver() {
        if (!orderMap.isEmpty()) {
            orderMap.remove(orderMap.keySet().iterator().next());
        } else {
            throw new RuntimeException("You don't have any orders to deliver!");
        }
    }

    public void deliver(int orderNumber) {
        if (orderNumber >= 0 && orderMap.containsKey(orderNumber)) {
            orderMap.remove(orderNumber);
        } else {
            throw new RuntimeException("Wrong order number!");
        }
    }

    public String draw() {
        StringBuilder orderTable = new StringBuilder();
        orderTable.append("Num | Name\n");
        for (Order order : new ArrayList<>(orderMap.values())) {
            orderTable.append(String.format("%-3d | %s%n", order.getOrderNumber(), order.getCustomerName()));
        }
        return orderTable.toString();
    }
}
