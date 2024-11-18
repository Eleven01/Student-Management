package com.example.Student_Management.service;

import com.example.Student_Management.*;.model.Student;
import com.example.Student_Management.*;.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> searchByName(String name) {
        return studentRepository.findByFirstNameIgnoreCase(name);
    }

    public List<Student> searchByGpaAndGender(double minGpa, double maxGpa, String gender) {
        return studentRepository.findByGpaBetweenAndGender(minGpa, maxGpa, gender);
    }

    @Cacheable("averageGpa")
    public double calculateAverageGpaByGender(String gender) {
        List<Student> students = studentRepository.findByGender(gender);
        return students.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
    }
} 

