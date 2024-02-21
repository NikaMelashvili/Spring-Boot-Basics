package mvc.melashvili.formtomysql.controller.repository;

import mvc.melashvili.formtomysql.controller.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
}
