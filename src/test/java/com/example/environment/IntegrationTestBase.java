package com.example.environment;

import io.micronaut.test.support.TestPropertyProvider;

import java.util.HashMap;
import java.util.Map;

public abstract class IntegrationTestBase implements Postgres, TestPropertyProvider {

    @Override
    public Map<String, String> getProperties() {
        return new HashMap<>(getPostgresProperties());
    }
}
