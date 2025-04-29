package com.example.model;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "basic_id")
    private Basic basic;
}
