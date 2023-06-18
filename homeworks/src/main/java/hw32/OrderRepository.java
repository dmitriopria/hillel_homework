package hw32;

import hw25.exceptions.JdbcOperationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderRepository {
    private ProductRepository productRepository;

    public OrderRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order getOrderById(int id) {
        Order order;
        String sql = SQLQuery.GET_ORDER_BY_ID;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = mapOrder(resultSet);
            } else {
                throw new JdbcOperationException("Can't find any order with ID %d!".formatted(id));
            }
            return order;
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't extract order from DB by ID %d".formatted(id));
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = SQLQuery.GET_ALL_ORDERS;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Order order = mapOrder(resultSet);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't extract orders from DB");
        }
    }

    public Order addOrder(Product product) {
        Objects.requireNonNull(product);
        String sql = SQLQuery.ADD_ORDER;
        Order order = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, product.getCost());
            preparedStatement.setInt(2, product.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = mapOrder(resultSet);
                saveOrderProducts(order, product);
            }
            return order;
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't add order with product %s".formatted(product));
        }
    }

    public void deleteOrder(int id) {
        String sql = SQLQuery.DELETE_ORDER_BY_ID;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() < 1) {
                throw new JdbcOperationException("Order with ID %d was not deleted".formatted(id));
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't delete order with ID %d".formatted(id));
        }
    }

    public Order modifyOrder(int orderId, Product product) {
        Order order = null;
        String sql = SQLQuery.MODIFY_ORDER_BY_ID;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setDouble(2, product.getCost());
            preparedStatement.setInt(3, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = mapOrder(resultSet);
                saveOrderProducts(order, product);
            }
            return order;
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't modify order with ID %d".formatted(orderId));
        }
    }

    private void saveOrderProducts(Order order, Product product) {
        Objects.requireNonNull(order);
        Objects.requireNonNull(product);
        productRepository.addProduct(product);
        linkOrderToProduct(order.getId(), product.getId());
    }

    private void linkOrderToProduct(int orderId, int productId) {
        if (orderId < 1 || productId < 1) {
            throw new JdbcOperationException("Illegal arguments: Product id is " + productId + ", order id is " + orderId);
        }
        String sql = SQLQuery.LINK_PRODUCT_TO_ORDER;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, productId);
            int result = preparedStatement.executeUpdate();
            if (result < 1) {
                throw new JdbcOperationException("Product " + productId + " was not added to order " + orderId);
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't link product " + productId + " to order " + orderId);
        }
    }

    private Order mapOrder(ResultSet resultSet) {
        Objects.requireNonNull(resultSet);
        try {
            int id = resultSet.getInt(1);
            Date date = resultSet.getTimestamp(2);
            double cost = resultSet.getDouble(3);
            List<Product> products = getProductsForOrder(id);
            return new Order(id, date, cost, products);
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't extract order from DB");
        }
    }

    private List<Product> getProductsForOrder(int orderId) {
        if (orderId < 1) {
            throw new JdbcOperationException("Order id can't be negative or zero!");
        }
        List<Product> products = new ArrayList<>();
        String sql = SQLQuery.GET_PRODUCTS_FOR_ORDER;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = productRepository.mapProduct(resultSet);
                    products.add(product);
                }
            }
            return products;
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't get product for order %d".formatted(orderId));
        }
    }
}