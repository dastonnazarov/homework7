package org.example.dto;



import org.example.enums.StudentRole;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String birthDate;
    private StudentRole role;


    public Student() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public StudentRole getRole() {
        return role;
    }

    public void setRole(StudentRole role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", createdDate=" + birthDate +
                ", role=" + role +
                '}';
    }
}