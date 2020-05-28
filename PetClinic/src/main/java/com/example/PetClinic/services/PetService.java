package com.example.PetClinic.services;

import com.example.PetClinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{

    Set<Pet> findByOwnerId(Long id);

}
