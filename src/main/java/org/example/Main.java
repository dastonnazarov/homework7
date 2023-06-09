package org.example;


import org.example.config.Config;
import org.example.controller.AdminController;
import org.example.db.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {


    public static void main(String[] args) {
        Database.initAdmins();
        Database.createBookTable();
        Database.createStudentTable();
        Database.createStudentBookTable();

       ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AdminController adminController = (AdminController) context.getBean("adminController");
       adminController.start();


        /*

            **  Library Project **
Do project using Spring core(@Repository,@Component,@Service,@Autowired)
Controller + Service + Repository

Book (id,title,author, publishYear, amount, visible)   (amount - shu kitobdan nechta borligi)
Student (id, name, surname,phone, createdDate, visible)
StudentBook (id,student_id,book_id,createdDate,status(TAKEN,RETURNED),returnedDate,duration)

visible - true bo'lsa demak Entity o'chirilmagan
visible - false bo'lsa demak Entity o'chirilgan va uni ishlatilmaydi.
Delete qilmaymizda uni statusini false qilamiz.


** Menu **
1. LogIn
0. Exit


Registration yo'q. Studentlarni sistemaga Admin qo'shadi shundan keyin ular login qilishlari mumkun.


--- User Menu ---
1. Book bist (kitoblar)
  OrderNumber  BookTitle  BookAuthor
2. Take book (kitob olish)
  Enter book Id

  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
   Agar kitob qolmagan bo'lsa berilmasin.
3. Taken book (Olib lekin qaytarmagan kitoblar)
  Studentni olib hali qaytarmagan kitoblari. Konsolga quyidagilar chiqsin
    OrderNumber  BookTitle  BookAuthor TakenTime (kitobni olgan vaqti)
4. Return book
  Enter book id:

5. History (Shu studentni barcha olgan  topshirgan yoki hali topshirmagan kitoblar ro'yhati)
  Studentni olib qaytargan yoki olib hali qaytarmagan kitoblar tarixi.
  Konsolga quyidagilar chiqsin
    OrderNumber   BookTitle   BookAuthor   Status  TakenDate (kitobni olgan vaqti)    returnedDate

6. Order book (qandaydir kitob bo'lmasa kutubhonachida shu kitobni olib kelinglar deb yozish mumkun.)
  Enter book name:


--- Admin Menu ---
1. Book list
  OrderNumber  BookTitle  BookAuthor  Amount
2. Add book
  Enter title
  Enter author
  Enter amount
3. Delete book
  Enter id
4. Student List
5. Add Student
  Enter name
  Enter surname
  Enter phone
6. Delete student
  Enter Id
7. Student Taken book (studentlar olib hali qaytarmagan kitoblar ro'yhati.)
  Konsolga quyidagilar chiqsin
    OrderNumber  StudentName  StudentSurname StudentPhone   BookTitle  TakenDate (kitobni olgan vaqti)
8. BookTaken History (barcha studentlarni barcha olib topshirgan yoki hali topshirmagan kitoblar ro'yhati)
  Studentlarning olib qaytargan yoki olib hali qaytarmagan kitoblar tarixi.
  Konsolga quyidagilar chiqsin
    OrderNumber  StudentName  StudentSurname StudentPhone  BookTitle   BookAuthor   Status  TakenDate
(kitobni olgan vaqti)    returnedDate
         */

    }
}
