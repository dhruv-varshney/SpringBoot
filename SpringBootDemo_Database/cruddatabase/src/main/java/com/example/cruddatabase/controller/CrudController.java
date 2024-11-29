package com.example.cruddatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddatabase.Service.EmployeeService;

@RestController
public class CrudController {

    private EmployeeService employeeService;

    public CrudController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAllEmployees() {
        return employeeService.findAllEmployee().toString();
    }

}
