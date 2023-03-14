package org.example.repository;


import org.example.db.Database;
import org.example.dto.Student;
import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addTakeStudentBook(StudentBook studentBook) {
        String sql = "insert into studentBook (student_id,book_id,createdDate,status,returnedDate,duration ) " +
                "values('%s','%s',now(),'%s',now(),'%s')";
        sql = String.format(sql, studentBook.getStudent_id(),studentBook.getBook_id(),studentBook.getStatus(),studentBook.getDuration());
        int update = jdbcTemplate.update(sql);
        return update;
    }

    public List<StudentBook> getStudentTakeBookList() {
        String query = "select * from studentBook";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(StudentBook.class));
    }


}
