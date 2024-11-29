package com.example.restapi.restController;

import com.example.restapi.Exception.StudentError;
import com.example.restapi.Exception.StudentMissingException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restapi.entity.Student;

import java.util.List;


@RestController
@RequestMapping("/api")
public class restController {
    private List<Student> students;

    public restController(List<Student> students) {
        this.students = students;
    }

    @PostConstruct
    private void LoadStudent() {
        students.add(new Student("Ashish", "Choudhary"));
        students.add(new Student("Dhruv", "Varshney"));
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentMissingException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
