package org.example.service;

import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentBookRepository studentBookRepository;

    public String takeBook(Integer book_id) {

        Book book = bookRepository.getBookById(book_id);
    //   Student student = studentRepository.getStudentById(student_id);

        if (book == null ) {
            return "Student olgan kitoblar mavjud emas!";
        }
        int count = studentTookBookCount(book_id);
        if (count >= 5) {
            return "sorry, you can not take book  ";
        }
        StudentBook studentBooks = new StudentBook();
       // studentBooks.setStudent_id();
        studentBooks.setBook_id(book_id);
        studentBookRepository.addStudentBook(studentBooks);
        return "take book";
    }

    private int studentTookBookCount(Integer book_id) {
        int count = 0;
        for (StudentBook sb : studentBookRepository.getStudentBookList()) {
            if (sb.getBook_id().equals(book_id) && sb.getStatus().equals(Status.TAKEN)) {
                count++;
            }
        }
        return count;
    }


}
