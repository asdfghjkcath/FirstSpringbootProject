package com.example.enrollment.service;

import com.example.enrollment.entity.Teacher;
import com.example.enrollment.repository.impl.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacher(Integer teacherId) {
        return teacherRepository.getTeacher(teacherId);
    }

    public Teacher getTeacherByFirstName(String teacherFirstName) {
        return teacherRepository.getTeacherByFirstName(teacherFirstName);
    }

    public Teacher getTeacherByLastName(String teacherLastName) {
        return teacherRepository.getTeacherByLastName(teacherLastName);
    }

    public List<Teacher> getTeacherByMajor(String teacherMajor) {
        return teacherRepository.getTeacherByMajor(teacherMajor);
    }
}
