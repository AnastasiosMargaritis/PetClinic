package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.repositories.OwnerRepository;
import com.example.PetClinic.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PetController {

    private final PetService petService;
    private final OwnerRepository ownerRepository;

    public PetController(PetService petService, OwnerRepository ownerRepository) {
        this.petService = petService;
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

    @PostMapping("create/{id}")
    public Optional<Pet> createPet(@PathVariable Long id, @RequestBody Pet pet){

        return ownerRepository.findById(id).map(owner -> {
            pet.setOwner(owner);
            return petService.save(pet);
        });
    }


}
