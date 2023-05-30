package com.bootcamp.restapiwithjpa.service;

import com.bootcamp.restapiwithjpa.course.Course;
import com.bootcamp.restapiwithjpa.repository.StudentRepository;
import com.bootcamp.restapiwithjpa.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void enrollCourse(Student student, Course course) {
        student.setCourse(course);
        studentRepository.save(student);
    }

    public void dropCourse(Student student) {
        student.setCourse(null);
        studentRepository.save(student);
    }
}
