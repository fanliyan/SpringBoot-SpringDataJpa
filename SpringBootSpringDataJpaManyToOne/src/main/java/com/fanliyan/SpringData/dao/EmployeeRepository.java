package com.fanliyan.SpringData.dao;

import com.fanliyan.SpringData.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
