package com.example.PetClinic.controllers;


import com.example.PetClinic.model.Vet;
import com.example.PetClinic.services.VetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/vets")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<Vet> listVets(Model model){
        return this.vetService.findAll();
    }
}
