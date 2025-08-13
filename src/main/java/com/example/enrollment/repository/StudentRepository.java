package com.example.enrollment.repository;

import com.example.enrollment.entity.Student;

public interface StudentRepository {
    Integer saveStudent(Student student);

    Student getStudent(Integer id);

    Student getStudentByFirstName(String firstName);

}
