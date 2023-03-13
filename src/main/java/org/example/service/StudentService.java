package org.example.service;


import org.example.controller.AdminController;
import org.example.controller.StudentController;
import org.example.dto.Student;
import org.example.enums.StudentRole;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private StudentController studentController;


    public void isAdminOrStudent(String phone) {
        //   Student exist = studentRepository.getStudentByPhone(phone.getPhone());
        Student exist = studentRepository.getStudentByPhone(phone);
        if (exist == null) {
            System.err.println("not found!!!");
        } else if (exist.getPhone().equals("4477")) {
            adminController.adminStart();
        } else {
            studentController.studentStart();
        }
    }


   /* public void addStudent(Student student) {
        Student exist = studentRepository.getStudentByPhone(student.getPhone());
        if (exist != null) {
            System.out.println("sorry that student already exist!!!");
            adminController.adminSectionMenu();

        } else {
            student.setCreatedDate(LocalDate.now());
            studentRepository.saveStudent(student);
            System.out.println("Student is create successfully");
        }

    }*/

    public void studentList() {
        System.out.println("----------   Student List ----------");
        List<Student> cards = studentRepository.getAllStudent();
        cards.forEach(student -> System.out.println(student));
    }

    public void deleteStudent(Integer id) {
//        int Id = studentRepository.getStudentById(id);
//        if(Id==0){
//          System.out.println("Student doesn't find!!");
//          adminController.adminSectionMenu();
//          return;
//      }else {
            Integer integer = studentRepository.deleteStudent(id);
            if(integer==1){
            System.out.println("student is successfully deleted");
          //  System.out.println(integer);
            }else {
                System.out.println("not found");
            }
    //  }
    }

    public void addStudent(String name, String surname, String phone, String birthDate) {
        Student exist = studentRepository.getStudentByPhone(phone);

        if (exist != null) {
            System.out.println("sorry that student already exist!!!");
            adminController.adminSectionMenu();

        } else {

            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setBirthDate(birthDate);
            student.setRole(StudentRole.STUDENT);

            studentRepository.saveStudent(student);
            System.out.println("Student is create successfully");
        }
    }
}


