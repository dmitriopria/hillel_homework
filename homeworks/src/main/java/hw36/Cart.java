package hw36;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class Cart {
    private final List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(Objects.requireNonNull(product));
    }

    public void removeProductById(int id) {
        if (id < 1) {
            throw new RuntimeException("Product ID can't be negative or zero!");
        }
        Optional<Product> productToRemove = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        productToRemove.ifPresent(products::remove);
    }

    public List<Product> getProducts() {
        return products;
    }
}
