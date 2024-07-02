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
        private int documents_id;
        private String documents_name;
        private String documents_type;
        private String documents_url;
        private Date uploaded_at;


        public Documents(int documentsId) {

            documents_id = documentsId;
        }

        public Documents(int documentsId, String documents_name, String documents_type, String documents_url, Date uploaded_at) {
            documents_id = documentsId;
            this.documents_name = documents_name;
            this.documents_type = documents_type;
            this.documents_url = documents_url;
            this.uploaded_at = uploaded_at;
        }

    public Documents() {

    }

    public int getDocuments_id() {
            return documents_id;
        }

        public String getDocuments_name() {
            return documents_name;
        }

        public String getDocuments_type() {
            return documents_type;
        }

        public String getDocuments_url() {
            return documents_url;
        }

        public Date getUploaded_at() {
            return uploaded_at;
        }

        public void setDocuments_name(String documents_name) {
            this.documents_name = documents_name;
        }

        public void setDocuments_type(String documents_type) {
            this.documents_type = documents_type;
        }

        public void setDocuments_url(String documents_url) {
            this.documents_url = documents_url;
        }

        public void setUploaded_at(Date uploaded_at) {
            this.uploaded_at = uploaded_at;
        }

    public void setDocuments_id(int documentId) {
            this.documents_id=documentId;
    }
}

