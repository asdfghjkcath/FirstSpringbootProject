package com.example.enrollment.service;


import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentAllStudentProcess(String firstName){
        List<Student> students = studentRepository.getAllStudentsByFirstName(firstName);

        for(Student student:students){
            student.setAge(Period.between(student.getBirthDate(), LocalDate.now()).getYears());
        }
        return students;
    }
}
