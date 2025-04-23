package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Basic {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SubBasic> subBasics;
}
