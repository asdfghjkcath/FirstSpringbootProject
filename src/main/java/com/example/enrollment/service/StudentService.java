package com.example.enrollment.service;

import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(Integer id){
        return studentRepository.getStudent(id);
    }

    public Student getStudentByFirstName(String firstName) {
        return studentRepository.getStudentByFirstName(firstName);
    }

    public Integer saveStudent(Student student) {
        int age = Period.between(student.getBirthDate(), LocalDate.now()).getYears();
        student.setAge(age); // Optional: if your Student entity has an `age` field
        return studentRepository.saveStudent(student);
    }

    public void updateStudentBirthdayById(String birthdate, Integer id){
        LocalDate parsedDate = LocalDate.parse(birthdate, DateTimeFormatter.ISO_DATE);
        studentRepository.updateStudentBirthdayById(birthdate, id);
    };

    public List<Student> getStudentAllStudentProcess(String firstName) {
        List<Student> students = studentRepository.getAllStudentsByFirstName(firstName);

        for (Student student : students) {
            student.setAge(Period.between(student.getBirthDate(), LocalDate.now()).getYears());
        }
        return students;
    }

}
