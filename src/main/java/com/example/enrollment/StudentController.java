package com.example.enrollment;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/student")
public class StudentController {
    private Student student;


    @GetMapping
    public Student getStudent() {

        return this.student;

    }
    @PostMapping
    public String saveStudent(@RequestBody Student student) {
        this.student = student;
        int age = Period.between(student.getBirthDate(), LocalDate.now()).getYears();
        this.student.setAge(age);
        return "successfully save";
    }

}
