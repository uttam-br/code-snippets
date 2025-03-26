package com.example.jpa_hibernate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course extends BaseEntity {

    private String courseName;

    private int credits;

//    @ManyToMany
//    private List<Student> studentList;

    /*
        One course can have multiple entries in StudentCourse table
        One StudentCourse can belong to only one course.
        1:M relationship
        To prevent from creating separate relationship table by this entity, Adding mappedBy here.
     */
    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;


}
