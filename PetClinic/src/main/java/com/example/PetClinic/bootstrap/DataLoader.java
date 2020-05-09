package com.example.PetClinic.bootstrap;

import com.example.PetClinic.model.Index;
import com.example.PetClinic.model.Owner;
import com.example.PetClinic.model.Vet;
import com.example.PetClinic.services.OwnerService;
import com.example.PetClinic.services.VetService;
import com.example.PetClinic.services.map.IndexServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final IndexServiceMap indexService;

    public DataLoader(IndexServiceMap indexService, OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.indexService = indexService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("Michael", "Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner("Fiona", "Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet("San", "Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

        Index index1 = new Index("Welcome to our Pet Clinic!", "This is a Pet Clinic Web App. It is build with Angular 9 and Spring Framework 5!");
        indexService.save(index1);

    }
}
