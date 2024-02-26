package crud.melashvili.mapping1;

import crud.melashvili.mapping1.dao.AddressDAO;
import crud.melashvili.mapping1.dao.StudentDAO;
import crud.melashvili.mapping1.entity.Address;
import crud.melashvili.mapping1.entity.Student;
import crud.melashvili.mapping1.services.AddressService;
import crud.melashvili.mapping1.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Mapping1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mapping1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AddressService addressService, StudentService studentService){
		return runner -> {
			addFullSet(addressService, studentService);
		};
	}

	private void addFullSet(AddressService addressService, StudentService studentService) {
		Student student = new Student("Nika");
		Address address = new Address("Chavchavadzis 9");
		student.addAddress(address);
		studentService.addStudent(student);
//		addressService.addAddress(address);
	}
}
