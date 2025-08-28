package com.example.enrollment.entity;

public class Teacher {
    private Integer teacherId;
    private String teacherFirstName;
    private String teacherSurname;
    private String teacherMajor;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherSurname='" + teacherSurname + '\'' +
                ", teacherMajor='" + teacherMajor + '\'' +
                '}';
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherMajor() {
        return teacherMajor;
    }

    public void setTeacherMajor(String teacherMajor) {
        this.teacherMajor = teacherMajor;
    }
}
