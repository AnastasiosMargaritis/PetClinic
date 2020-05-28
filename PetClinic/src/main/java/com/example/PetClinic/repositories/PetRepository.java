package com.example.PetClinic.repositories;

import com.example.PetClinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface PetRepository extends CrudRepository<Pet, Long> {

    Set<Pet> findByOwnerId(Long id);
}
