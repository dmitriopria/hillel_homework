package hw36;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope("prototype")
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
        products.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .ifPresent(products::remove);
    }

    public List<Product> getProducts() {
        return products;
    }
}
