package hw31.jdbc;

import hw31.entity.Product;
import hw31.exception.JdbcOperationException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Repository
public class ProductRepository {

    public void addProduct(Product product) {
        Objects.requireNonNull(product);
        String sql = SQLQuery.ADD_PRODUCT;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't add product %s to DB".formatted(product));
        }
    }

    public Product mapProduct(ResultSet resultSet) {
        Objects.requireNonNull(resultSet);
        try {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double cost = resultSet.getDouble(3);
            return new Product(id, name, cost);
        } catch (SQLException e) {
            throw new JdbcOperationException("Can't extract product from DB");
        }
    }
}

