package org.example.store.database;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductDao {

    private final ConnectionBuilder connectionBuilder;

    public ProductDao(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try (var connection = getConnection()) {
            var statement = connection.prepareStatement(ProductSqlStatement.GET_ALL_WITH_ALL_FIELDS.getStatement());
            var rs = statement.executeQuery();
            while (rs.next()) {
                products.add(Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .desc(rs.getString("desc"))
                        .build());
            }
        } catch (SQLException | NamingException e) {
            log.error(ExceptionUtils.getMessage(e));
        }

        return products;
    }

    private Connection getConnection() throws SQLException, NamingException {
        return connectionBuilder.getConnection();
    }
}
