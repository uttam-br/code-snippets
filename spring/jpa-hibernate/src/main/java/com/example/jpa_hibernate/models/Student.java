package com.example.jpa_hibernate.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student extends BaseEntity {

    private String name;

    private int age;

    /*
        This mappedBy prevents creating separate relationship table.
        This tells that student attribute in Address is already used as mapping these two entities.
     */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address;


    /*
        Student can be enrolled in multiple courses,
        Course can have multiple students, hence
        ManyToMany
        In this case, it's required to create new separate relations table.

        Keeping ManyToMany in both current and other table will create two separate relationship table doing the same thing.
        We can any one of the entity not to create relationship table,
        either by removing the annotation altogether (THIS GIVES COMPILATION ERROR AS WE CANNOT HAVE NON-BASIC ELEMENTS WITHOUT SUCH ANNOTATIONS)
        .or telling in annotation to not create separate relationship table.
        mappedBy is perfect for this.
     */
//    @ManyToMany(mappedBy = "studentList")
//    private List<Course> courses;


    /*
        One student can have multiple entries in StudentCourse table
        One StudentCourse can belong to only one student.
        1:M relationship
        To prevent from creating separate relationship table by this entity, Adding mappedBy here.
     */
    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourses;

}
