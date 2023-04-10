package homework17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeOrderBoard {
    private List<Order> orderList = new ArrayList<>();
    private int orderNumber;

    public void add(String customerName) {
        Objects.requireNonNull(customerName);
        orderList.add(new Order(++orderNumber, customerName));
    }

    public void deliver() {
        if (!orderList.isEmpty()) {
            orderList.remove(0);
        } else {
            throw new ArrayStoreException("You don't have any orders to deliver!");
        }
    }

    public void deliver(int orderNumber) {
        boolean orderFound = false;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNumber() == orderNumber) {
                orderList.remove(i);
                orderFound = true;
                break;
            }
        }
        if (!orderFound) {
            throw new ArrayStoreException("Wrong order number!");
        }
    }

    public void draw() {
        System.out.println("Current orders:");
        for (Order order : orderList) {
            System.out.println("Order " + order.getOrderNumber() + " for " + order.getCustomerName());
        }
    }
}
