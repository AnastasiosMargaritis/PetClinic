package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.services.OwnerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OwnerController {

    private final OwnerService ownerService;


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<Owner> listOwners(){
        List<Owner> sorted = this.ownerService.findAll().stream().collect(Collectors.toList());
        Collections.sort(sorted, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sorted;
    }
}
