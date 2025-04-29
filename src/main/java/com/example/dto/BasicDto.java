package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.UUID;

@Introspected
@Serdeable
public record BasicDto(@Nullable UUID id,
                       String name,
                       String description,
                       List<SubBasicDto> subBasics) {
}