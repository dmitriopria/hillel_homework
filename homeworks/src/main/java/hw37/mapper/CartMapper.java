package hw37.mapper;

import hw37.dao.ProductDao;
import hw37.entity.Cart;
import hw37.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static hw37.SQLQuery.*;

@Component
public class CartMapper implements RowMapper<Cart> {
    private JdbcTemplate jdbcTemplate;
    private ProductDao productDao;

    public CartMapper(final JdbcTemplate jdbcTemplate, final ProductDao productDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.productDao = productDao;
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getLong("id"));
        if (cart.getId() != null) {
            List<Integer> productIds = jdbcTemplate.queryForList(SELECT_PRODUCTS_FROM_CART, Integer.class, cart.getId());
            List<Product> products = productIds.stream()
                    .map(productId -> productDao.getProductById(productId))
                    .collect(Collectors.toList());
            cart.setProducts(products);
        }
        return cart;
    }
}