package org.example.controller;
import org.example.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentBookController {
    @Autowired
    StudentBookService studentBookService;

    public void takeBook(Integer id){
        studentBookService.takeBook(id);
    }



}

