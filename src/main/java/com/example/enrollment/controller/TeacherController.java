package com.example.enrollment.controller;

import com.example.enrollment.entity.Teacher;
import com.example.enrollment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Teacher getTeacher(@RequestParam Integer teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @GetMapping("teacher-fName")
    public Teacher getTeacherByFName(@RequestParam String teacherFirstName) {
        return teacherService.getTeacherByFName(teacherFirstName);
    }

    @GetMapping("teacher-lName")
    public Teacher getTeacherByLName(@RequestParam String teacherLastName) {
        return teacherService.getTeacherByLName(teacherLastName);
    }

    @GetMapping("teacher-MajorSub")
    public List<Teacher> getTeacherByMajor(@RequestParam String teacherMajor) {
        return teacherService.getTeacherByMajor(teacherMajor);
    }
}
