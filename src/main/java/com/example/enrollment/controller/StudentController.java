package com.example.enrollment.controller;

import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import com.example.enrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    @GetMapping
    public Student getStudentById(@RequestParam Integer id) {

        return studentRepository.getStudentById(id);
    }

    @PostMapping
    public Integer saveStudent(@RequestBody Student student) {

        int age = Period.between(student.getBirthDate(), LocalDate.now()).getYears();


        return studentRepository.saveStudent(student);
    }
    @GetMapping("/search")
    public Student getStudentByFirstName(@RequestParam String firstName) {
        return studentRepository.getStudentByFirstName(firstName);
    }


    @GetMapping("/find")
    public List<Student> getAllStudentByFirstName(@RequestParam String firstName){
        return studentService.getStudentAllStudentProcess(firstName);
    }
}
