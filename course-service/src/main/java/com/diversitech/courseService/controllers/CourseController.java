package com.diversitech.courseService.controllers;

import com.diversitech.courseService.model.Course;
import com.diversitech.courseService.model.Documents;
import com.diversitech.courseService.service.CourseService;
import com.diversitech.courseService.model.Classes;
import com.diversitech.courseService.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")

public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseByCourseId(@PathVariable int courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        ResponseEntity<Void> response = courseService.deleteCourse(id);
        return response;
    }


    @GetMapping("/{courseId}/classes")
    public ResponseEntity<List<Classes>> getClassesByCourseId(@PathVariable int courseId) {
        return courseService.getClassesListResponseEntity(courseId);
    }

    @GetMapping("/{courseId}/documents")
    public ResponseEntity<List<Documents>> getDocumentsByCourseId(@PathVariable int courseId) {
        return courseService.getDocumentsListResponseEntity(courseId);
    }

//    @Autowired
//    private ExcelService excelService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        System.out.println("in handleFileUpload");
//        try {
//            List<Course> courses = excelService.readExcelFile(file);
//            // Process the list of students (e.g., save to database)
//            return ResponseEntity.ok("File processed successfully");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file");
//        }
//    }
}











