package com.example.enrollment.repository.impl;

import com.example.enrollment.entity.Student;
import com.example.enrollment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer saveStudent(Student student) {
        String sql = "INSERT INTO STUDENTS(s_first_name,s_last_name,s_middle_name,s_address,s_birthdate) \n " +
                "VALUES(:firstName,:lastName,:middleName,:address,:birthdate);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName",student.getFirstName());
        parameterSource.addValue("lastName",student.getLastName());
        parameterSource.addValue("middleName",student.getMiddleName());
        parameterSource.addValue("address",student.getAddress());
        parameterSource.addValue("birthdate",student.getBirthDate());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,parameterSource, keyHolder, new String[] { "student_id" });

        return keyHolder.getKey().intValue();
    }

    @Override
    public Student getStudent(Integer id) {
        String sql = "SELECT s_first_name,s_last_name,s_middle_name,s_address,s_birthdate from students \n" +
                "WHERE student_id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);

        return namedParameterJdbcTemplate.queryForObject(sql,parameterSource, studentRowMapper());
    }


    private RowMapper<Student> studentRowMapper() {
        return (rs, rowNum) -> {
            Student student = new Student();
            student.setFirstName(rs.getString("s_first_name"));
            student.setMiddleName(rs.getString("s_middle_name"));
            student.setLastName(rs.getString("s_last_name"));
            student.setAddress(rs.getString("s_address"));
            student.setBirthDate(rs.getDate("s_birthdate").toLocalDate());
            return student;
        };
    }
}
