package hw36;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1, "ШОКОЛАД", 10.0));
        products.add(new Product(2, "БУРГЕР", 20.0));
        products.add(new Product(3, "ПИЦЦА", 30.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(int id) {
        if (id < 1) {
            throw new RuntimeException("Product ID can't be negative or zero!");
        }
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
}
