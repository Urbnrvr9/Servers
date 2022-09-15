package org.example.store.database;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionBuilder {

    Connection getConnection() throws NamingException, SQLException;
}
