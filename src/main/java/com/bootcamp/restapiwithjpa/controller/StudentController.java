package com.bootcamp.restapiwithjpa.controller;

import com.bootcamp.restapiwithjpa.course.Course;
import com.bootcamp.restapiwithjpa.service.StudentService;
import com.bootcamp.restapiwithjpa.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @PostMapping("/enroll/{id}")
    public void enrollCourse(@PathVariable Long id, @RequestBody Course course) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.enrollCourse(student, course);
        }
    }

    @PostMapping("/drop/{id}")
    public void dropCourse(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.dropCourse(student);
        }
    }
}
