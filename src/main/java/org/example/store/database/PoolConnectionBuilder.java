package org.example.store.database;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class PoolConnectionBuilder implements ConnectionBuilder {

    @Override
    public Connection getConnection() throws NamingException, SQLException {
        return getDataSource().getConnection();
    }

    private DataSource getDataSource() throws NamingException {
        try {
            var context = new InitialContext();
            return (DataSource) context.lookup("java:/comp/env/jdbc/TestDB");
        } catch (NamingException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw e;
        }
    }
}
