package com.example.enrollment.repository.impl;

import com.example.enrollment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer saveTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (teacher_name, teach_surname, teacher_major) VALUES\n" +
                "(:teacherFirstName, :teacherSurname, :teacherMajor);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("teacherFirstName", teacher.getTeacherFirstName());
        parameterSource.addValue("teacherSurname", teacher.getTeacherSurname());
        parameterSource.addValue("teacherMajor", teacher.getTeacherMajor());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] {"teacher_id"});
        return keyHolder.getKey().intValue();


    }

    @Override
    public Teacher getTeacher(Integer teacherId) {
        String sql = "SELECT teacher_name, teach_surname, teacher_major FROM teacher \n" +
                "WHERE teacher_id = :teacherId";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("teacherId", teacherId);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, teacherRowMapper());
    }

    @Override
    public Teacher getTeacherByFirstName(String teacherFirstName) {
        String sql = "SELECT * FROM teacher WHERE teacher_name = :teacherFirstName";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("teacherFirstName", teacherFirstName);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, teacherRowMapper());
    }

    @Override
    public Teacher getTeacherByLastName(String teacherLastName) {
        String sql = "SELECT * FROM teacher WHERE teach_surname = :teacherLastName";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("teacherLastName", teacherLastName);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, teacherRowMapper());
    }

    public List<Teacher> getTeacherByMajor(String teacherMajor) {
        String sql = "SELECT * FROM teacher WHERE teacher_major = :teacherMajor";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("teacherMajor", teacherMajor);

        List<Teacher> teacherResult = namedParameterJdbcTemplate.query(sql, parameterSource, teacherRowMapper());
        return teacherResult;
    }

    private RowMapper<Teacher> teacherRowMapper() {
        return (rs, rowNum) -> {
            Teacher teacher = new Teacher();

            teacher.setTeacherFirstName(rs.getString("teacher_name"));
            teacher.setTeacherSurname(rs.getString("teach_surname"));
            teacher.setTeacherMajor(rs.getString("teacher_major"));
            teacher.setTeacherId(rs.getInt("teacher_id"));

            return teacher;
        };
    }



}
