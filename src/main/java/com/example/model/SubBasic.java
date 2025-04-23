package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class SubBasic {

    @Id
    @GeneratedValue
    private UUID id;
    private int x;
    private int y;
}
