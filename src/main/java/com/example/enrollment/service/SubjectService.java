package com.example.enrollment.service;

import com.example.enrollment.entity.Subject;
import com.example.enrollment.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Integer saveSubject(String subjectName) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);

        return subjectRepository.saveSubject(subject);
    }

    public Subject getSubjectName(String subjectName) {
        return subjectRepository.getSubjectName(subjectName);
    }

    public List<Subject> getAllSubjectProcess() {
        return subjectRepository.getAllSubject();

    }


}
