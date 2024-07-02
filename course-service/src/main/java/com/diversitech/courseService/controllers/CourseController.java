package com.diversitech.courseService.controllers;

import com.diversitech.courseService.model.Course;
import com.diversitech.courseService.model.Documents;
import com.diversitech.courseService.service.CourseService;
import com.diversitech.courseService.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        System.out.println("inside getAllCourses");
        return courseService.getCourses();
    }

    @GetMapping("/courseId")
    public ResponseEntity<Course> getCourseByCourseId(@RequestParam String courseId) {
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
}











