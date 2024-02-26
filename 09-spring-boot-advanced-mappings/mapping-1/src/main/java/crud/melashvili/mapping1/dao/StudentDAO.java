package crud.melashvili.mapping1.dao;

import crud.melashvili.mapping1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
}
