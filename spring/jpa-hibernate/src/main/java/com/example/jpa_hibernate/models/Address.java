package com.example.jpa_hibernate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseEntity {

    private String streetName;

    private String city;

    private String pin;

    /*
    * ManyToOne make sure that we are creating column in current table that maps to the other table.
    * Because we know current table will always to have one value in that column.
    * Many elements in current table can map to only one element in other table.
    * */
    @ManyToOne()
    private Student student;

}
