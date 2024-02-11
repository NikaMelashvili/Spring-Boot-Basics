package com.melashvili.cruddemo;

import com.melashvili.cruddemo.dao.StudentDAO;
import com.melashvili.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int deletedRows = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + deletedRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studId = 3;
		studentDAO.delete(studId);
		queryForStudents(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studId = 1;
		Student student = studentDAO.findById(studId);
		student.setFirstName("Nika");
		studentDAO.updates(student);
		System.out.println(student.getFirstName());
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> lastNameStudent = studentDAO.findByLastName("melashvili");
		for(Student tempStudent : lastNameStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentsList = studentDAO.findAll();
		for(Student tempStudent : studentsList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create
		System.out.println("Creating the student...");
		Student student1 = new Student("Nikoloz", "Melashvili", "nikoloz@gmail.com");
		// save
		System.out.println("Saving student...");
		studentDAO.save(student1);
		// display id
		System.out.println("Student ID is: " + student1.getId());
		// retrieve by id
		int currentId = student1.getId();
		// display student
		System.out.println("The student info is " + studentDAO.findById(currentId));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		creating
		System.out.println("Creating 2 student object...");
		Student tempStudent1 = new Student("Temuka", "Melashvili", "temuka@gmail.com");
		Student tempStudent2 = new Student("ana", "Melashvili", "ana@gmail.com");

//		saving
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
	}

	private void createStudent(StudentDAO studentDAO) {
//		create student object
		System.out.println("Creating the student object...");
		Student tempStudent = new Student("sofo", "Mikiashvili", "sofo@gmail.com");

//		save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		show student id
		System.out.println("The id is: " + tempStudent.getId());
	}
}
