package hw37;

public class SQLQuery {
    public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM products WHERE id = ?";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT id, name, price FROM products WHERE id = ?";
    public static final String SELECT_ALL_PRODUCTS = "SELECT id, name, price FROM products";

    public static final String CREATE_CART = "INSERT INTO carts DEFAULT VALUES";
    public static final String SELECT_LAST_CART_ID = "SELECT LASTVAL()";
    public static final String INSERT_PRODUCT_IN_CART = "INSERT INTO cart_items (cart_id, product_id) VALUES (?, ?)";
    public static final String DELETE_PRODUCT_FROM_CART = "DELETE FROM cart_items WHERE product_id = ?";
    public static final String DELETE_ALL_PRODUCTS_FROM_CART = "DELETE FROM cart_items WHERE cart_id = ?";
    public static final String DELETE_CART_BY_ID = "DELETE FROM cart WHERE id = ?";
    public static final String SELECT_PRODUCTS_FROM_CART = "SELECT cart_id, product_id FROM cart_items WHERE cart_id = ?";
}
