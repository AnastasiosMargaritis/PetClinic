package com.example.PetClinic.bootstrap;

import com.example.PetClinic.model.*;
import com.example.PetClinic.services.springdatajpa.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerSDJpaService ownerService;
    private final VetSDJpaService vetService;
    private final IndexSDJpaService indexService;
    private final PetTypeSDJpaService petTypeService;
    private final VisitSDJpaService visitService;
    private final SpecialitySDJpaService specialitiesService;
    private final PetSDJpaService petService;

    public DataLoader(OwnerSDJpaService ownerService,
                      VetSDJpaService vetService,
                      IndexSDJpaService indexService,
                      PetTypeSDJpaService petTypeService,
                      VisitSDJpaService visitService,
                      SpecialitySDJpaService specialitiesService,
                      PetSDJpaService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.indexService = indexService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
        this.specialitiesService = specialitiesService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner("Michael", "Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        petService.save(mikesPet);

        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner("Fiona", "Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);


        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
