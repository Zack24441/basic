package com.example.controller;

import com.example.dto.BasicDto;
import com.example.service.BasicService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import java.util.List;
import java.util.UUID;

@Controller("api/v1/basic")
public class BasicController {

    private BasicService basicService;

    @Get
    public List<BasicDto> getAll() {
        return basicService.getAll();
    }

    @Get("/{id}")
    public BasicDto get(@PathVariable UUID id) {
        return basicService.get(id);
    }

    @Post
    public void save(BasicDto basicDto) {
        basicService.save(basicDto);
    }
}
