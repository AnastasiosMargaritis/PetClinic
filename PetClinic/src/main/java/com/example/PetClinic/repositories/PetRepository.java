package com.example.PetClinic.repositories;

import com.example.PetClinic.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
