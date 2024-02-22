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
			saveInstrucor(instructorDAO);
		};
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
