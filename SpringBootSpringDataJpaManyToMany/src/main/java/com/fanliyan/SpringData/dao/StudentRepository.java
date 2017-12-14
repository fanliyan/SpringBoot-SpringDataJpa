package com.fanliyan.SpringData.dao;

import com.fanliyan.SpringData.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByStudentName(String name);

}
