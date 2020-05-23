package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public Set<Pet> getAllPets(){
        return this.petService.findAll();
    }

    @GetMapping("owner/{id}")
    public Pet getPetByOwner(@PathVariable Long id){
        return this.petService.findByOwnerId(id);
    }
}
