package hw37.dao;

import hw37.entity.Product;
import hw37.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;
import java.util.Objects;

import static hw37.SQLQuery.*;

public class ProductDao {
    private JdbcTemplate jdbcTemplate;
    private ProductMapper productMapper;

    public ProductDao(final JdbcTemplate jdbcTemplate, final ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    public Product addProduct(final Product product) {
        Objects.requireNonNull(product);
        if (!Objects.isNull(product.getId())) {
            throw new IllegalArgumentException("Can't add product with ID!");
        }
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
        Number id = insert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
        );
        product.setId(id.longValue());
        return product;
    }

    public boolean removeProduct(final int productId) {
        validatePositiveIdNumber(productId);
        int rowsDeleted = jdbcTemplate.update(DELETE_PRODUCT_BY_ID, productId);
        return rowsDeleted >= 1;
    }

    public Product getProductById(final int productId) {
        validatePositiveIdNumber(productId);
        return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, productMapper, productId);
    }

    public List<Product> getAllProducts() {
        return jdbcTemplate.query(SELECT_ALL_PRODUCTS, productMapper);
    }

    private void validatePositiveIdNumber(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID can't be zero or negative!");
        }
    }
}
