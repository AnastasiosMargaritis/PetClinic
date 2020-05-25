package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.repositories.OwnerRepository;
import com.example.PetClinic.services.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerRepository ownerRepository;


    public OwnerController(OwnerService ownerService, OwnerRepository ownerRepository) {
        this.ownerService = ownerService;
        this.ownerRepository =ownerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<Owner> listOwners(){
        List<Owner> sorted = this.ownerService.findAll().stream().collect(Collectors.toList());
        Collections.sort(sorted, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sorted;
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id){

        return this.ownerService.findById(id);
    }

    @GetMapping("/search")
    public List<Owner> processFindForm(@RequestParam String keyword){

        if(keyword.isEmpty()){
            List<Owner> results = this.ownerService.findAll().stream().collect(Collectors.toList());
            return results;
        }

        List<Owner> results = ownerService.findByLastNameOrFirstNameContains(keyword, keyword);

        return results;
    }

    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id,
                                             @RequestBody Owner newOwner){
        return this.ownerRepository.findById(id)
                .map(owner -> {
                    owner.setFirstName(newOwner.getFirstName());
                    owner.setLastName(newOwner.getLastName());
                    owner.setAddress(newOwner.getAddress());
                    owner.setCity(newOwner.getCity());
                    owner.setTelephone(newOwner.getTelephone());
                    return this.ownerRepository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return this.ownerRepository.save(newOwner);
                });
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner){
        return this.ownerService.save(owner);
    }
}
