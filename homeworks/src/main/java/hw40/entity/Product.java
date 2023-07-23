package hw40.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "products", schema = "postgres")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderProduct> orderProducts;

    public Product(String name, Double cost, List<OrderProduct> orderProducts) {
        this.name = name;
        this.cost = cost;
        this.orderProducts = orderProducts;
    }
}
