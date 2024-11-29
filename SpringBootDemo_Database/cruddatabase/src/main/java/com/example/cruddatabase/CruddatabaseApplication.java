package com.example.cruddatabase;

import com.example.cruddatabase.dao.StudentDAO;
import com.example.cruddatabase.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			findAllStudents(studentDAO);
//			findStudentsByFirstName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAllStudents();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(4);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student tempStudent = studentDAO.findStudent(2);
		System.out.println("Student found: " + tempStudent);
		tempStudent.setLastName("Mruthyunjaya");
		studentDAO.updateStudent(tempStudent);
		System.out.println("Student updated: " + tempStudent);
	}

	private List<Student> findStudentsByFirstName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findStudentsByFirstName();
		System.out.println("Students found: " +
				students.size());
		for(Student student : students) {
			System.out.println("Student found: " + student);
		}
		return students;
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAllStudents();
		System.out.println("Students found: " +
				students.size());
		for(Student student : students) {
			System.out.println("Student found: " + student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = studentDAO.findStudent(1);
		System.out.println("Student found: " + tempStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Dhruv", "Varshney", "dhruv.varshney@bazaarvoice.com");
		Student tempStudent2 = new Student("Adithya", "M", "adithya.m@bazaarvoice.com");
		Student tempStudent3 = new Student("Tanvi", "Gupta", "tanvi.gupta@bazaarvoice.com");
		Student tempStudent4 = new Student("Amrendra", "Jha", "amrendra.jha@bazaarvoice.com");
		Student tempStudent5 = new Student("Rohit", "Roy", "rohit.roy@bazaarvoice.com");
		studentDAO.saveStudent(tempStudent1);
		studentDAO.saveStudent(tempStudent2);
		studentDAO.saveStudent(tempStudent3);
		studentDAO.saveStudent(tempStudent4);
		studentDAO.saveStudent(tempStudent5);

	}
}
