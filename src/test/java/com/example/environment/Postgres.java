package com.example.environment;

import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainerProvider;

import java.util.HashMap;
import java.util.Map;

public interface Postgres {

    JdbcDatabaseContainer<?> DB = new PostgreSQLContainerProvider().newInstance();

    default Map<String, String> getPostgresProperties() {
        Map<String, String> prop = new HashMap<>();
        prop.put("datasource.default.url", DB.getJdbcUrl());
        prop.put("datasource.default.username", DB.getUsername());
        prop.put("datasource.default.password", DB.getPassword());
        return prop;
    }
}
