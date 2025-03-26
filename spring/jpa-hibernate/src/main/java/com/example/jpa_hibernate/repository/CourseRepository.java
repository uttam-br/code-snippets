package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
