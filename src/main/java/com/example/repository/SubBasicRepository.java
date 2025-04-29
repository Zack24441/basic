package com.example.repository;

import com.example.model.SubBasic;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface SubBasicRepository extends CrudRepository<SubBasic, UUID> {
}
