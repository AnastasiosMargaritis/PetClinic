package com.example.PetClinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "index")
public class Index extends BaseEntity {

    @Column(name = "message")
    private String message;

    @Column(name = "description")
    private String description;

}
