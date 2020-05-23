package com.example.PetClinic.services;

import com.example.PetClinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

}
