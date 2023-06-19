package hw32;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private Date creationDate;
    private double cost;
    List<Product> products;

    public Order(int id, Date creationDate, double cost, List<Product> products) {
        this.id = id;
        this.creationDate = creationDate;
        this.cost = cost;
        this.products = products;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.cost, cost) == 0 && Objects.equals(creationDate, order.creationDate) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, cost, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
