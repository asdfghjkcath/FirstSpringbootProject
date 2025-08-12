package com.example.enrollment.controller;

import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping
    public Student getStudent(@RequestParam Integer id) {

        return studentRepository.getStudent(id);

    }


    @PostMapping
    public String saveStudent(@RequestBody Student student) {

        return "successfully save " +  studentRepository.saveStudent(student);
    }

}
