package com.example.enrollment.entity;

public class Subject {
    private Integer subjectId;
    private String subjectName;

    @Override
    public String toString() {
        return "Subject{" +
        "subjectId='" + subjectId + '\''+
        ",subjectName='" + subjectName + '\''+
        '}';
    }


    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
