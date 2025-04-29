package com.example.controller;

import com.example.dto.BasicDto;
import com.example.service.BasicService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller("api/v1/basic")
public class BasicController {

    private final BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @Get
    public List<BasicDto> getAll() {
        return basicService.getAll();
    }

    @Get("/{id}")
    public BasicDto get(@PathVariable UUID id) {
        return basicService.get(id);
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    public BasicDto save(@Body BasicDto basicDto) {
        return basicService.save(basicDto);
    }
}
