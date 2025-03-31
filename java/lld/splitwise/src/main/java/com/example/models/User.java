package com.example.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {

    private String name;

    private String email;

    private String password;

}
