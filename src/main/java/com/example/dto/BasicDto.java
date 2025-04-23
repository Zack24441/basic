package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class BasicDto {

    private String name;
    private String description;
    private List<SubBasicDto> subBasics;
}