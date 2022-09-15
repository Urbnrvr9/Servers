package org.example.store.database;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductSqlStatement {

    GET_ALL_WITH_ALL_FIELDS("SELECT id, name, desc FROM product");

    private final String statement;
}
