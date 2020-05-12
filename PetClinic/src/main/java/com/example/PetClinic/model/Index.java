package com.example.PetClinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "index")
public class Index extends BaseEntity {

    @Column(name = "message")
    private String message;

    @Column(name = "description")
    private String description;

    @Builder
    public Index(Long id, String message, String description) {
        super(id);
        this.message = message;
        this.description = description;
    }
}
