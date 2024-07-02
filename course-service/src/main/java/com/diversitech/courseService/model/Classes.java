package com.diversitech.courseService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;
    private int course_Id;
    private String class_name;
    private String description;
    private Date start_date;
    private Date end_date;

    public Classes() {
    }

    public Classes(int class_id, int course_Id, String class_name, String description, Date start_data, Date end_data) {
        this.class_id = class_id;
        this.course_Id = course_Id;
        this.class_name = class_name;
        this.description = description;
        this.start_date = start_data;
        this.end_date = end_data;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart_date(Date start_data) {
        this.start_date = start_data;
    }

    public void setEnd_date(Date end_data) {
        this.end_date = end_data;
    }
}
