package com.example.enrollment.repository;

import com.example.enrollment.entity.Student;

import java.util.List;

public interface StudentRepository {
    Integer saveStudent(Student student);

    Student getStudentById(Integer id);

    Student getStudentByFirstName(String firstName);

    void updateStudentBirthdateById(String birthdate, Integer studentId);

    List<Student> getAllStudentsByFirstName(String firstName);
}
