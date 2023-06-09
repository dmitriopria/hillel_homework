package hw31.jdbc;

import hw31.exception.JdbcOperationException;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

@Service
public class DBConnection {
    private static final String DB_PROPS = "db.properties";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";

    private static final DataSource DATA_SOURCE;

    static {
        DATA_SOURCE = initDataSource();
    }

    public static Connection getConnection() {
        try {
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            throw new JdbcOperationException("Connection to DB  was not successful!", e);
        }
    }

    public static void close(Connection connection) {
        Objects.requireNonNull(connection);
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Unable to close DB connection!", e);
        }
    }

    private static Properties loadProperties() {
        try (InputStream is = DBConnection.class.getClassLoader().getResourceAsStream(DB_PROPS)) {
            Properties dbProperties = new Properties();
            dbProperties.load(is);
            return dbProperties;
        } catch (IOException e) {
            throw new JdbcOperationException("DB properties loading was not successful!", e);
        }
    }

    private static DataSource initDataSource() {
        Properties properties = loadProperties();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(properties.getProperty(DB_URL));
        dataSource.setUser(properties.getProperty(DB_USERNAME));
        dataSource.setPassword(properties.getProperty(DB_PASSWORD));
        return dataSource;
    }
}
