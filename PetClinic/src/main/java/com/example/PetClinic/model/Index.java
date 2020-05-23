package com.example.PetClinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "index")
public class Index extends BaseEntity {

    @Column(name = "message")
    private String message;

    @Lob
    @Column(name = "description")
    private String description;

    @Builder(builderMethodName = "indexBuilder")
    public Index(Long id, String message, String description) {
        super(id);
        this.message = message;
        this.description = description;
    }
}
