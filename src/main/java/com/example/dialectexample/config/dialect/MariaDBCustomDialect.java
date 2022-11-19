package com.example.dialectexample.config.dialect;

import org.hibernate.dialect.MariaDB103Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MariaDBCustomDialect extends MariaDB103Dialect {

    public MariaDBCustomDialect() {
        super();
        registerFunction("FORMAT", new StandardSQLFunction("FORMAT", StandardBasicTypes.STRING));
    }
}
