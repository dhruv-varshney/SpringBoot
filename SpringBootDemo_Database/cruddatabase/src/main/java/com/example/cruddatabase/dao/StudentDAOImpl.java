package com.example.cruddatabase.dao;

import com.example.cruddatabase.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> thequery = entityManager.createQuery("Select s FROM Student s", Student.class);
        return thequery.getResultList();
    }

    @Override
    public List<Student> findStudentsByFirstName() {
        TypedQuery<Student> thequery = entityManager.createQuery("Select s FROM Student s WHERE s.firstName = 'Dhruv'", Student.class);
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAllStudents() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
