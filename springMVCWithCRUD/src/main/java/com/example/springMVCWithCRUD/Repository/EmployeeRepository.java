package com.example.springMVCWithCRUD.Repository;

import com.example.springMVCWithCRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
