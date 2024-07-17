package com.diversitech.courseService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private int documentsId;
    private String documentsName;
    private String documentsType;
    private String documentsUrl;

    public Documents(int courseId, int documentsId, String documentsName, String documentsType, String documentsUrl) {
        this.courseId = courseId;
        this.documentsId = documentsId;
        this.documentsName = documentsName;
        this.documentsType = documentsType;
        this.documentsUrl = documentsUrl;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getDocumentsId() {
        return documentsId;
    }

    public void setDocumentsId(int documentsId) {
        this.documentsId = documentsId;
    }

    public String getDocumentsName() {
        return documentsName;
    }

    public void setDocumentsName(String documentsName) {
        this.documentsName = documentsName;
    }

    public String getDocumentsType() {
        return documentsType;
    }

    public void setDocumentsType(String documentsType) {
        this.documentsType = documentsType;
    }

    public String getDocumentsUrl() {
        return documentsUrl;
    }

    public void setDocumentsUrl(String documentsUrl) {
        this.documentsUrl = documentsUrl;
    }

    public Documents() {

    }
}

