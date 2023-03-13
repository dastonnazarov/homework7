package org.example.repository;


import org.example.db.Database;
import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentBookRepository {

    public void addStudentBook(StudentBook studentBooks) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into studentBook (student_id,book_id,localDate,status,returnedDate,duration)values(?,?,now(),?,now(),?");
            preparedStatement.setInt(1, studentBooks.getStudent_id());
            preparedStatement.setInt(2, studentBooks.getBook_id());
            preparedStatement.setString(3, studentBooks.getDuration().toString());
            preparedStatement.setInt(4, studentBooks.getDuration());
            int i = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<StudentBook> getStudentBookList() {
        List<StudentBook> studentBookList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from studentBook");
            while (resultSet.next()) {
                StudentBook studentBook = new StudentBook();
                studentBook.setId(resultSet.getInt("id"));
                studentBook.setStudent_id(resultSet.getInt("student_id"));
                studentBook.setBook_id(resultSet.getInt("book_id"));
                studentBook.setLocalDate(resultSet.getTimestamp("localDate").toLocalDateTime().toLocalDate());
                studentBook.setStatus(Status.valueOf(resultSet.getString("status")));
                studentBook.setReturnedDate(resultSet.getTimestamp("returnedDate").toLocalDateTime().toLocalDate());
                studentBook.setDuration(resultSet.getInt("duration"));
                studentBookList.add(studentBook);
            }
            connection.close();
            return studentBookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
