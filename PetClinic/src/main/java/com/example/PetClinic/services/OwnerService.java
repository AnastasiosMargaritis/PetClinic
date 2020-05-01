package com.example.PetClinic.services;

import com.example.PetClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
