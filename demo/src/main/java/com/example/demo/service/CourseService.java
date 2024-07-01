package com.example.demo.service;

import com.example.demo.model.Classes;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void init() {
        printDocumentsServicePath();
    }

    public void printDocumentsServicePath() {
        System.out.println("documentsServicePath: " + documentsServicePath);
    }
    public ResponseEntity<List<Classes>> getListResponseEntity(int courseId) {
        String classServiceUrl = classesHost + classesByCourseIdPath + courseId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Classes>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Classes>> response = restTemplate.exchange(classServiceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Classes>>() {});
        return response;
    }
}
