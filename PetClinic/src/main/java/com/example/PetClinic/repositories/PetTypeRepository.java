package com.example.PetClinic.repositories;

import com.example.PetClinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    PetType findByName(String name);

    Set<PetType> findAll();
 }
