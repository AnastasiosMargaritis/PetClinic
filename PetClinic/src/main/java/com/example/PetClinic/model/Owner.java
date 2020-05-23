package com.example.PetClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "owners")
public class Owner extends Person {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @Builder(builderMethodName = "ownerBuilder")
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.pets = pets;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

}
