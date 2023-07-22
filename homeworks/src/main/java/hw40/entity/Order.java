package hw40.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "orders", schema = "postgres")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public Order(LocalDateTime date, Double cost, List<Product> products) {
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
}
