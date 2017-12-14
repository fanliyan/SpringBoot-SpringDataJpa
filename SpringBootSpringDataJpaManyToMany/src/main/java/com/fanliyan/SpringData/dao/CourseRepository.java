package com.fanliyan.SpringData.dao;

import com.fanliyan.SpringData.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String name);
}
