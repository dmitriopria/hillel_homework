package hw37.mapper;

import hw37.dao.ProductDao;
import hw37.entity.Cart;
import hw37.entity.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapper implements RowMapper<Cart> {
    private ProductDao productDao;

    public CartMapper(final ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getLong("cart_id"));
        if (cart.getId() != null) {
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                long productId = rs.getLong("product_id");
                Product product = productDao.getProductById(productId);
                products.add(product);
            }
            cart.setProducts(products);
        }
        return cart;
    }
}