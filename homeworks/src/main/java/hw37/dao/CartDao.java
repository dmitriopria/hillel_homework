package hw37.dao;

import hw37.entity.Cart;
import hw37.entity.Product;
import hw37.mapper.CartMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static hw37.SQLQuery.*;

@Repository
public class CartDao {
    private JdbcTemplate jdbcTemplate;
    private CartMapper cartMapper;

    public CartDao(final JdbcTemplate jdbcTemplate, final CartMapper cartMapper) {
        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate);
        this.cartMapper = Objects.requireNonNull(cartMapper);
    }

    public Cart createCart() {
        jdbcTemplate.update(CREATE_CART);
        Long cartId = jdbcTemplate.queryForObject(SELECT_LAST_CART_ID, Long.class);
        Cart cart = new Cart();
        cart.setId(cartId);
        return cart;
    }

    public boolean addToCart(final Cart cart, final Product product) {
        Objects.requireNonNull(cart);
        Objects.requireNonNull(product);
        int insertionResult = jdbcTemplate.update(INSERT_PRODUCT_IN_CART, cart.getId(), product.getId());
        return insertionResult >= 1;
    }

    public boolean removeFromCart(Long productId) {
        validatePositiveIdNumber(productId);
        int removingResult = jdbcTemplate.update(DELETE_PRODUCT_FROM_CART, productId);
        return removingResult >= 1;
    }

    public boolean deleteCart(Long cartId) {
        validatePositiveIdNumber(cartId);
        int removingProducts = jdbcTemplate.update(DELETE_ALL_PRODUCTS_FROM_CART, cartId);
        int deletingCart = jdbcTemplate.update(DELETE_CART_BY_ID, cartId);
        return removingProducts >= 1 && deletingCart >= 1;
    }

    public Cart getCartById(Long cartId) {
        validatePositiveIdNumber(cartId);
        return jdbcTemplate.queryForObject(SELECT_PRODUCTS_FROM_CART, cartMapper, cartId);
    }

    private void validatePositiveIdNumber(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID can't be zero or negative!");
        }
    }
}