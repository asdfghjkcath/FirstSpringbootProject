package com.example.enrollment.repository.impl;

import com.example.enrollment.entity.Subject;
import com.example.enrollment.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Integer saveSubject(Subject subject) {
        String sql = "INSERT INTO subject (subject_name) VALUES \n" +
                "(:subjectName);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("subjectName", subject.getSubjectName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] {"subject_id"});
        return keyHolder.getKey().intValue();
    }

    @Override
    public Subject getSubjectName(String subjectName) {
        String sql = "SELECT * FROM subject where subject_name = :subjectName";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("subjectName", subjectName);
        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, subjectRowMapper());
    }

    private RowMapper<Subject> subjectRowMapper() {
        return (rs, rowNum) -> {
            Subject subject = new Subject();

            subject.setSubjectName(rs.getString("subject_name"));
            subject.setSubjectId(rs.getInt("subject_id"));

            return subject;
        };
    }

    public List<Subject> getAllSubject() {
        String sql = "SELECT * FROM subject";
        return namedParameterJdbcTemplate.query(sql, subjectRowMapper());
    }
}
