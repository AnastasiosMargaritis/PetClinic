package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.repositories.OwnerRepository;
import com.example.PetClinic.repositories.PetRepository;
import com.example.PetClinic.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PetController {

    private final PetService petService;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetController(PetService petService, PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petService = petService;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public Set<Pet> getAllPets(){
        return this.petService.findAll();
    }

    @GetMapping("owner/{id}")
    public Set<Pet> getPetByOwner(@PathVariable Long id){
        return this.petService.findByOwnerId(id);
    }

    @PostMapping("owners/{id}/create")
    public Optional<Pet> createPet(@PathVariable Long id,
                                   @RequestBody Pet pet){

        return ownerRepository.findById(id).map(owner -> {
            pet.setOwner(owner);
            return petService.save(pet);
        });
    }

    @PutMapping("/details/{petId}")
    public Optional<Pet> updatePet(@PathVariable Long petId,
                                   @RequestBody Pet updatedPet){

        return this.petRepository.findById(petId).map(pet -> {
            pet.setName(updatedPet.getName());
            return this.petRepository.save(pet);
        });
    }


}
