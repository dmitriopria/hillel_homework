package hw39.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Order {
    private Long id;
    private LocalDateTime date;
    private Double cost;
    private List<Product> products;

    public Order(LocalDateTime date, Double cost, List<Product> products) {
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
}
