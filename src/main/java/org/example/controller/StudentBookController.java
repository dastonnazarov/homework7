package org.example.controller;
import org.example.repository.BookRepository;
import org.example.repository.StudentRepository;
import org.example.service.BookService;
import org.example.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentBookController {
    @Autowired
    StudentBookService studentBookService;
    @Autowired
    private AdminController adminController;
    @Autowired
    private BookService bookService;



    public void userSectionMenu() {
        System.out.println("--------------------  User Menu  ----------------");
        System.out.println("1.Book List");
        System.out.println("2.Take book");
        System.out.println("3.Taken book List");
        System.out.println("4.Return book");
        System.out.println("5.History");
        System.out.println("6.Order book");
        System.out.println("0.Exit");
    }

    public void studentStart() {
        while (true) {
            userSectionMenu();
            Integer option = adminController.getAction();
            switch (option) {
                case 1:
                    bookList();
                    break;
                case 2:
                    takeBook();
                    break;
                case 3:
                    takenBookList();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    History();
                    break;
                case 6:
                    orderBook();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("wrong option!!!");
                    break;
            }
        }
    }



    private void bookList() {
        bookService.adminAllBookList();
    }



    private void takeBook() {
        System.out.print("Enter book Id: ");
        Integer id = adminController.scannerN.nextInt();

        studentBookService.studentTakeBook(id);
    }



    private void takenBookList() {
           studentBookService.sTakeBookList();
    }

    private void returnBook() {
    }


    private void History() {
    }

    private void orderBook() {
    }



}

