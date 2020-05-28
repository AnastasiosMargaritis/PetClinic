package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.model.PetType;
import com.example.PetClinic.repositories.PetRepository;
import com.example.PetClinic.repositories.PetTypeRepository;
import com.example.PetClinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;


    public PetSDJpaService(PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        this.petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return this.petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {

        PetType petType = new PetType();

        if(this.petTypeRepository.findByName(object.getPetType().getName()) == null){
            Set<PetType> types = this.petTypeRepository.findAll();
            int size = types.size();
            petType.setName(object.getPetType().getName());
        }else{
           petType = this.petTypeRepository.findByName(object.getPetType().getName());
        }

        this.petTypeRepository.save(petType);
        object.setPetType(petType);

        return this.petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        this.petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.petRepository.deleteById(aLong);
    }

    @Override
    public Set<Pet> findByOwnerId(Long id) {
        return this.petRepository.findByOwnerId(id);
    }
}
