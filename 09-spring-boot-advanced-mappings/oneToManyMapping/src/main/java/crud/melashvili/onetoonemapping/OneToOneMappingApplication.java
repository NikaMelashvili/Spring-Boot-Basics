package crud.melashvili.onetoonemapping;

import crud.melashvili.onetoonemapping.dao.InstructorDAO;
import crud.melashvili.onetoonemapping.entity.Course;
import crud.melashvili.onetoonemapping.entity.Instructor;
import crud.melashvili.onetoonemapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OneToOneMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
//			saveInstrucor(instructorDAO);
//			getById(instructorDAO);
//			deleteById(instructorDAO);
//			findInstructorDetail(instructorDAO);
//			deleteDetailById(instructorDAO);
//			createInstructorWithCourses(instructorDAO);
//			findInstructorWithCourses(instructorDAO);
			findCoursesForInstructors(instructorDAO);
		};
	}

	private void findCoursesForInstructors(InstructorDAO instructorDAO) {
		int id = 2;
		Instructor temp = instructorDAO.findInstructorById(id);
		List<Course> courses = instructorDAO.findCoursesByInstructorId(id);
		temp.setCourses(courses);
		System.out.println(temp.getCourses());
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {
		int id = 2;
		Instructor temp = instructorDAO.findInstructorById(id);
		System.out.println(temp);
		System.out.println(temp.getCourses());
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		// instructor
		Instructor tempInstrucor =
				new Instructor("Susan", "Smith", "susan@gmail.com");

//		instructor details
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com",
				"Comics");
		tempInstrucor.setInstructorDetail(instructorDetail);
		System.out.println("Instructor saved.");

//		courses

		Course course1 = new Course("Java Core (Java 17)");
		Course course2 = new Course("C++ beginner to pro");
		Course course3 = new Course("Python Basics");

		tempInstrucor.addCourse(course1);
		tempInstrucor.addCourse(course2);
		tempInstrucor.addCourse(course3);

		System.out.println("Saving Courses...");
		System.out.println("Instructor: " + tempInstrucor);
		System.out.println("Courses: " + tempInstrucor.getCourses());
		instructorDAO.save(tempInstrucor);

		System.out.println("Done");
	}

	private void deleteDetailById(InstructorDAO instructorDAO) {
		int id = 3;
		instructorDAO.deleteInstructorMethodById(id);
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		int id = 1;
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(id);
		System.out.println("The Instructor detail: " + instructorDetail);
		System.out.println("The associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteById(InstructorDAO instructorDAO) {
		int id = 2;
		instructorDAO.deleteInstructorById(id);
		System.out.println("Deleted instructor by id " + id);
	}

	private void getById(InstructorDAO instructorDAO) {
		int id = 1;
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println(instructor);
	}

	private void saveInstrucor(InstructorDAO instructorDAO) {
		Instructor tempInstrucor =
				new Instructor("Jonas", "Schmedtmen", "jonas@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com/pewdiepie",
				"Manga");
		tempInstrucor.setInstructorDetail(instructorDetail);
		instructorDAO.save(tempInstrucor);
		System.out.println("Instructor saved.");
	}
}
