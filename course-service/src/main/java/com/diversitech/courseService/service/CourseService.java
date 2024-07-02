package com.diversitech.courseService.service;

import com.diversitech.courseService.model.Classes;
import com.diversitech.courseService.model.Course;
import com.diversitech.courseService.model.Documents;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CourseService {

    private final RestTemplate restTemplate;

    @Value("${external-apis.documents-service.urls.paths.docByCourseIdPath}")
    private String documentsServicePath;
    @Value("${external-apis.documents-service.urls.host}")
    private String documentsHost;

    @Value("${external-apis.classes-service.urls.paths.classesByCourseIdPath}")
    private String classesByCourseIdPath;
    @Value("${external-apis.classes-service.urls.host}")
    private String classesHost;

    @Value("${external-apis.db-connector.urls.paths.getCourses}")
    private String getCourses;
    @Value("${external-apis.db-connector.urls.paths.getCourseById}")
    private String getCourseById;
    @Value("${external-apis.db-connector.urls.paths.addCourse}")
    private String addCourse;
    @Value("${external-apis.db-connector.urls.paths.updateCourse}")
    private String updateCourse;
    @Value("${external-apis.db-connector.urls.paths.deleteCourse}")
    private String deleteCourse;
    @Value("${external-apis.db-connector.urls.host}")
    private String dbConnectorHost;

    @Autowired
    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Course> getCourseById(String courseId) {
        String url = dbConnectorHost + getCourseById + courseId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Course> entity = new HttpEntity<>(headers);
        ResponseEntity<Course> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Course>() {
        });
        return response;
    }
//    public ResponseEntity<List<Course>> getCourses() {
//        List<Course> courses = new ArrayList<>();
//
//        // דוגמאות לנתוני קורסים דמוייניים
//        courses.add(new Course(1, "Introduction to Java", "Learn the basics of Java programming language", new Date(), new Date()));
//        courses.add(new Course(2, "Web Development with Angular", "Build dynamic web applications with Angular framework", new Date(), new Date()));
//        courses.add(new Course(3, "Database Design and Management", "Learn SQL and database management concepts", new Date(), new Date()));
//
//        return new ResponseEntity<>(courses, HttpStatus.OK);
//    }
    public ResponseEntity<List<Course>> getCourses() {
        String url = dbConnectorHost + getCourses;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Course>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Course>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Course>>() {
        });
        return response;
    }

    public ResponseEntity<Course> addCourse(Course course) {
        String url = dbConnectorHost + addCourse;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Course> entity = new HttpEntity<>(course, headers);
        ResponseEntity<Course> response = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Course>() {
        });
        return response;
    }

    public ResponseEntity<Course> updateCourse(String courseId, Course course) {
        String url = dbConnectorHost + updateCourse + courseId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Course> entity = new HttpEntity<>(course, headers);
        ResponseEntity<Course> response = restTemplate.exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<Course>() {
        });
        return response;
    }

    public ResponseEntity<Void> deleteCourse(String courseId) {
        String url = dbConnectorHost + deleteCourse + courseId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class
        );
        return response;
    }

    public ResponseEntity<List<Classes>> getClassesListResponseEntity(int courseId) {
        String classServiceUrl = classesHost + classesByCourseIdPath + courseId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Classes>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Classes>> response = restTemplate.exchange(classServiceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Classes>>() {
        });
        return response;
    }

    public ResponseEntity<List<Documents>> getDocumentsListResponseEntity(int courseId) {
        String documentServiceUrl = documentsHost + documentsServicePath + courseId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Classes>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Documents>> response = restTemplate.exchange(documentServiceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Documents>>() {
        });
        return response;
    }
}
