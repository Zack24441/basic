package com.example.environment;

import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class IntegrationTestBase implements Postgres, TestPropertyProvider {

    static {
        DB.start();
    }

    @Override
    public Map<String, String> getProperties() {
        return new HashMap<>(getPostgresProperties());
    }
}
