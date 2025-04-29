package com.example.integration;

import com.example.environment.IntegrationTestBase;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class IntegrationTest extends IntegrationTestBase {

    @Test
    void basicTest(RequestSpecification spec) {
        final var actualBasics = spec.get("api/v1/basic").as(List.class);
        assertThat(actualBasics).isEmpty();
    }
}
