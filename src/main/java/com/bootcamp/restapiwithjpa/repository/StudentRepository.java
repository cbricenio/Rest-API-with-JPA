package com.bootcamp.restapiwithjpa.repository;

import com.bootcamp.restapiwithjpa.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
