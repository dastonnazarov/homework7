package org.example.repository;


import org.example.db.Database;
import org.example.dto.Book;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
/*    public void addBook(Book book){
        String sql = "insert into book (title,author, publishYear,amount)values('%s','%s',now(),'%s')";
        sql = String.format(sql,book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getAmount());
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }

    public Integer deleteStudent(Integer id){
        String sql = "delete from student where id = '%s'";
        sql = String.format(sql,id);
        return jdbcTemplate.update(sql);
    }

    public List<Student> getAllStudent(){
        String query  = "select * from student";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
    }

 *//*   public List<Student> getAllStudents() {
        List<Student> studentList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
               Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                studentList.add(student);
            }
            connection.close();
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }*//*

    public Student getStudentByPhone(String phone) {
        String query = String.format("select * from student where phone = '%s'",phone) ;
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getStudentById(Integer id){
        String query = "select * from where id="+id;
        Student student = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class));
        return student;
    }*/

    public void addBook(Book book) {
            try {
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into book (title,author,publishYear,amount)values(?,?,now(),?)");
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setDouble(3, book.getAmount());
                int i = preparedStatement.executeUpdate();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public List<Book> getBookList() {
        List<Book> bookList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(resultSet.getTimestamp("publishYear").toLocalDateTime().toLocalDate());
                book.setAmount(resultSet.getDouble("amount"));
                book.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                bookList.add(book);
            }
            connection.close();
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public int deleteBook(Integer id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Book getBookById(Integer id) {
        try {
            Book book = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(resultSet.getTimestamp("publishYear").toLocalDateTime().toLocalDate());
                book.setAmount(resultSet.getDouble("amount"));
                book.setVisible(Boolean.valueOf(resultSet.getString("visible")));
            }
            connection.close();
            return book;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
