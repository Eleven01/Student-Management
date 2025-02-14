package com.example.Student_Management.repository;

import com.example.Student_Management.*;.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameIgnoreCase(String name);
    List<Student> findByGpaBetweenAndGender(double minGpa, double maxGpa, String gender);
}