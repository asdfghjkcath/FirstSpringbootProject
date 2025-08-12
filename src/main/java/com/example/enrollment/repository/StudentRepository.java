package com.example.enrollment.repository;

import com.example.enrollment.entity.Student;
import org.springframework.stereotype.Repository;

public interface StudentRepository {
    Integer saveStudent(Student student);

    Student getStudent(Integer id);
}
