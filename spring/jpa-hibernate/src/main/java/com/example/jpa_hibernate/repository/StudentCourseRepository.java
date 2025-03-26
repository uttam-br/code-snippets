package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
}
