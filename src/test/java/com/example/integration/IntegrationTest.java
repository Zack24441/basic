package com.example.integration;

import com.example.dto.BasicDto;
import com.example.dto.SubBasicDto;
import com.example.environment.IntegrationTestBase;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.is;

@MicronautTest
public class IntegrationTest extends IntegrationTestBase {

    @Test
    void shouldReturnEmptyResponse(RequestSpecification spec) {
        spec
                .get("api/v1/basic")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    void shouldReturnNotFound(RequestSpecification spec) {
        spec
                .pathParam("id", UUID.randomUUID())
                .get("api/v1/basic/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    void shouldSaveBasic(RequestSpecification spec) {
        final var request = new BasicDto(null,
                                            randomAlphabetic(10),
                                            randomAlphabetic(20),
                                            List.of(
                                                    new SubBasicDto(0, 0),
                                                    new SubBasicDto(100, -100)
                                            ));

        var savedBasic = spec
                .body(request)
                .contentType(ContentType.JSON)
                .post("api/v1/basic")
                .then()
                .statusCode(201)
                .extract()
                .as(BasicDto.class);

        spec
                .pathParam("id", savedBasic.id())
                .get("api/v1/basic/{id}")
                .then()
                .statusCode(200);
    }
}
