package com.example.PetClinic.controllers;


import com.example.PetClinic.model.Vet;
import com.example.PetClinic.services.VetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vets")
@CrossOrigin(origins = "http://localhost:4200")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vet> listVets(){
        List<Vet> sorted = this.vetService.findAll().stream().collect(Collectors.toList());
        Collections.sort(sorted, (o1,o2) -> o1.getId().compareTo(o2.getId()));
        return sorted;
    }
}
