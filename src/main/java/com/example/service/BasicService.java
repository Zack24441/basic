package com.example.service;

import com.example.dto.BasicDto;
import com.example.mapper.BasicMapper;
import com.example.repository.BasicRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class BasicService {

    private final BasicRepository basicRepository;
    private final BasicMapper basicMapper;

    public BasicService(BasicRepository basicRepository, BasicMapper basicMapper) {
        this.basicRepository = basicRepository;
        this.basicMapper = basicMapper;
    }

    public List<BasicDto> getAll() {
        return basicRepository.findAll()
                .stream()
                .map(basicMapper::toDto)
                .toList();
    }

    public BasicDto get(UUID id) {
        final var basicOptional = basicRepository.findById(id);
        return basicOptional.map(basicMapper::toDto).orElse(null);
    }

    public void save(BasicDto basicDto) {
        final var basicToSave = basicMapper.toModel(basicDto);
        basicRepository.save(basicToSave);
    }
}
