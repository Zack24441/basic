package com.example.model;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Serdeable
@Entity
@Data
public class SubBasic {

    @Id
    @GeneratedValue
    private UUID id;
    private int x;
    private int y;
}
