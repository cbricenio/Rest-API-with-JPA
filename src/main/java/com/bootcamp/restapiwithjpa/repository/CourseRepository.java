package com.bootcamp.restapiwithjpa.repository;

import com.bootcamp.restapiwithjpa.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
