package com.example.enrollment.controller;

import com.example.enrollment.entity.Subject;
import com.example.enrollment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public Integer saveSubject(@RequestParam String subjectName) {
        return subjectService.saveSubject(subjectName);
    }

    @GetMapping("/subject-name")
    public Subject getSubjectName(@RequestParam String subjectName) {
        return subjectService.getSubjectName(subjectName);
    }

    @GetMapping("/find")
    public List<Subject> getAllSubject() {
        return subjectService.getAllSubjectProcess();
    }

}
