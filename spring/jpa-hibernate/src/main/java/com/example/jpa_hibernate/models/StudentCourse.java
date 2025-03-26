package com.example.jpa_hibernate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "student_id"})
)
public class StudentCourse extends BaseEntity {

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    private LocalDateTime courseStartingDate;

}
