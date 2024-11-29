package com.example.cruddatabase.dao;

import com.example.cruddatabase.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {
    public void saveStudent(Student student);


    public Student findStudent(int id);


    public List<Student> findAllStudents();


    public List<Student> findStudentsByFirstName();

    public void updateStudent(Student student);

    public void deleteStudent(int id);

    public void deleteAllStudents();
}
