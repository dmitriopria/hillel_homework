package hw31.jdbc;

public final class SQLQuery {
    private SQLQuery(){
    }

    public static final String ADD_PRODUCT = """
            INSERT INTO product (name, cost) VALUES (?, ?)
            """;
    public static final String ADD_ORDER = """
            INSERT INTO orders (cost, product_id) VALUES (?, ?)
            """;
    public static final String GET_ORDER_BY_ID = """
            SELECT o.id AS order_id, o.ordered_at, o.cost AS order_cost,
                   p.id AS product_id, p.name, p.cost AS product_cost
            FROM orders o JOIN product p ON o.product_id = p.id
            WHERE o.id = ?
            """;
    public static final String GET_ALL_ORDERS = """
            SELECT o.id AS order_id, o.ordered_at, o.cost AS order_cost,
                   p.id AS product_id, p.name, p.cost AS product_cost
            FROM orders o JOIN product p ON o.product_id = p.id
            """;
    public static final String LINK_PRODUCT_TO_ORDER = """
            INSERT INTO order_products (order_id, product_id) VALUES (?, ?)
            """;
    public static final String GET_PRODUCTS_FOR_ORDER = """
            SELECT p.id, p.name, p.cost FROM product p
            INNER JOIN order_products op ON p.id = op.product_id WHERE op.order_id = ?
            """;
}
