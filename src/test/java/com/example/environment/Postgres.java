package com.example.environment;

import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainerProvider;

import java.util.HashMap;
import java.util.Map;

public interface Postgres {

    JdbcDatabaseContainer<?> DB = new PostgreSQLContainerProvider().newInstance();

    default Map<String, String> getPostgresProperties() {
        Map<String, String> prop = new HashMap<>();
        prop.put("datasources.default.url", DB.getJdbcUrl());
        prop.put("datasources.default.username", DB.getUsername());
        prop.put("datasources.default.password", DB.getPassword());
        return prop;
    }
}
