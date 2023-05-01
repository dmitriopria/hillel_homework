package hw21;

import java.time.LocalDate;
import java.util.Objects;

import static hw21.ProductType.BOOK;

public class Product {
    private int id;
    private ProductType productType;
    private double price;
    private boolean discount;
    private LocalDate supplyDate;

    public Product(int id, ProductType productType, double price, boolean discount, LocalDate supplyDate) {
        this.id = id;
        this.productType = productType;
        this.price = price;
        this.discount = discount;
        this.supplyDate = supplyDate;
    }

    public boolean isBook() {
        return getType() == BOOK;
    }

    public boolean isCurrentYearSupply() {
        LocalDate now = LocalDate.now();
        return getSupplyDate().getYear() == now.getYear();
    }

    public int getId() {
        return id;
    }

    public ProductType getType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && discount == product.discount && productType == product.productType && Objects.equals(supplyDate, product.supplyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, price, discount, supplyDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + productType +
                ", price=" + price +
                ", discount=" + discount +
                ", supplyDate=" + supplyDate +
                '}';
    }
}

