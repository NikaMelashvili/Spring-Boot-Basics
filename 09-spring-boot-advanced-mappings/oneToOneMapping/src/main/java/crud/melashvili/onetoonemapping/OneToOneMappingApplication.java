package crud.melashvili.onetoonemapping;

import crud.melashvili.onetoonemapping.dao.InstructorDAO;
import crud.melashvili.onetoonemapping.entity.Instructor;
import crud.melashvili.onetoonemapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteDetailById(instructorDAO);
		};
	}

	private void deleteDetailById(InstructorDAO instructorDAO) {
		int id = 1;
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
