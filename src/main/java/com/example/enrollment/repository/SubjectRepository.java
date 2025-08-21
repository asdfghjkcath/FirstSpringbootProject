package com.example.enrollment.repository;

import com.example.enrollment.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    Integer saveSubject(Subject subject);

    Subject getSubjectName(String subjectName);

    List<Subject> getAllSubject();
}
