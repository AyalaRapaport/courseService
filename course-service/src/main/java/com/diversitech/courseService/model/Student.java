package com.diversitech.courseService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {

    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private StudentStatus status;

    public Student() {
    }

    public Student(String studentId, String firstName, String lastName, String email, String phone, StudentStatus status) {
        this.firstName = firstName;
        this.studentId = studentId;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

//    @Id
//    private int student_id;
//    private String first_name;
//    private String last_name;
//    private String email;
//    private String phone;
//    private StudentStatus status;
//    private LocalDateTime created_at;
//    private LocalDateTime updated_at;
//
//    public Student(int student_id, String first_name, String last_name, String email, String phone, StudentStatus status) {
//        this.student_id = student_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.phone = phone;
//        this.status = status;
//        this.created_at=LocalDateTime.now();
//        this.updated_at=LocalDateTime.now();
//    }
//
//    public Student() {
//
//    }
//
//    public LocalDateTime getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(LocalDateTime updated_at) {
//        this.updated_at = updated_at;
//    }
//
//    public int getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(int student_is) {
//        this.student_id = student_is;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }
}