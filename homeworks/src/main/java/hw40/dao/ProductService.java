package hw40.dao;

import hw40.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Product getProductById(final Long id) {
        validateProductId(id);
        return productRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(final Product product) {
        return productRepository.save(Objects.requireNonNull(product));
    }

    public void deleteProduct(final Long id) {
        validateProductId(id);
        productRepository.deleteById(id);
    }

    private void validateProductId(Long id) {
        Objects.requireNonNull(id);
        if (id <= 0) {
            throw new RuntimeException("Product ID mustn't be 0 or negative");
        }
    }
}
