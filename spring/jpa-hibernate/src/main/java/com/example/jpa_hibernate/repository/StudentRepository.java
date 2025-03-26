package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
