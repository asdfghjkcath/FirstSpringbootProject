package com.example.enrollment.repository.impl;

import com.example.enrollment.entity.Teacher;

public interface TeacherRepository {
    Integer saveTeacher(Teacher teacher);

    Teacher getTeacher(Integer id);

    Teacher getTeacherByFName(String teacherFirstName);

}
