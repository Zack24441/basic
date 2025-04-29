package com.example.service;

import com.example.dto.BasicDto;
import com.example.exception.BasicNotFoundException;
import com.example.mapper.BasicMapper;
import com.example.repository.BasicRepository;
import com.example.repository.SubBasicRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class BasicService {

    private final BasicRepository basicRepository;
    private final SubBasicRepository subBasicRepository;
    private final BasicMapper basicMapper;

    public BasicService(BasicRepository basicRepository,
                        SubBasicRepository subBasicRepository,
                        BasicMapper basicMapper) {
        this.basicRepository    = basicRepository;
        this.subBasicRepository = subBasicRepository;
        this.basicMapper        = basicMapper;
    }

    public List<BasicDto> getAll() {
        return basicRepository.findAll()
                              .stream()
                              .map(basicMapper::toDto)
                              .toList();
    }

    public BasicDto get(UUID id) {
        final var basicOptional = basicRepository.findById(id);
        return basicOptional
                .map(basicMapper::toDto)
                .orElseThrow(BasicNotFoundException::new);
    }

    @Transactional
    public BasicDto save(BasicDto basicDto) {
        final var basicToSave = basicMapper.toModel(basicDto);
        final var savedBasic  = basicRepository.save(basicToSave);
        subBasicRepository.saveAll(savedBasic.getSubBasics());
        return basicMapper.toDto(savedBasic);
    }
}
