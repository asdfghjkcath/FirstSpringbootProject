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
    public Student getStudent(@RequestParam Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/first-name")
    public Student getStudentByFirstName(@RequestParam String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }


    @PostMapping
    public Integer saveStudent(@RequestBody Student student) {
        int age = Period.between(student.getBirthDate(), LocalDate.now()).getYears();
        return studentService.saveStudent(student);
    }

    @PutMapping
    public String updateStudent(@RequestParam String birthdate, @RequestParam Integer id) {
        studentService.updateStudentBirthdayById(birthdate, id);
        return "Successfully Updated";
    }

    @GetMapping("/find")
    public List<Student> getStudentAllStudentProcess(@RequestParam String firstName) {
        return studentService.getStudentAllStudentProcess(firstName);
    }
}


//
