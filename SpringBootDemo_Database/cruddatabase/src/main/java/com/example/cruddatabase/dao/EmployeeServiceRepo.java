package com.example.cruddatabase.dao;

import com.example.cruddatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceRepo extends JpaRepository<Employee,Integer> {
}
