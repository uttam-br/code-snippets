package com.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity()
@Table(name = "groups", uniqueConstraints = @UniqueConstraint(columnNames = {"created_by_id", "description"}))
public class Group extends BaseEntity {

    private String description;

    @ManyToOne
//    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToMany
    @JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {"group_id", "members_id"}))
    private List<User> members;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

}
