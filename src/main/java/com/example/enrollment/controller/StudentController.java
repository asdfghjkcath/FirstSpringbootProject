package com.example.enrollment.controller;

import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/first-name")
    public Student getStudentByFirstName(@RequestParam String firstName) {
        return studentRepository.getStudentByFirstName(firstName);


    }



    @PostMapping
    public Integer saveStudent(@RequestBody Student student) {

        int age = Period.between(student.getBirthDate(), LocalDate.now()).getYears();


        return studentRepository.saveStudent(student);
    }

}
