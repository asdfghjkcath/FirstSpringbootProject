package com.example.enrollment.service;

import com.example.enrollment.entity.Teacher;
import com.example.enrollment.repository.impl.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacher(Integer teacherId) {
        return teacherRepository.getTeacher(teacherId);
    }

    public Teacher getTeacherByFName(String teacherFirstName) {
        return teacherRepository.getTeacherByFName(teacherFirstName);
    }
}
