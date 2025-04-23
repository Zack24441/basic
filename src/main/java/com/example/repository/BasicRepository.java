package com.example.repository;

import com.example.model.Basic;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface BasicRepository extends CrudRepository<Basic, UUID> {
}
