package com.example.enrollment.repository.impl;

import com.example.enrollment.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    Integer saveTeacher(Teacher teacher);

    Teacher getTeacher(Integer id);

    Teacher getTeacherByFirstName(String teacherFirstName);

    Teacher getTeacherByLastName(String teacherLastName);

    List<Teacher> getTeacherByMajor(String teacherMajor);

}
