package mvc.melashvili.formtomysql.controller.service;

import mvc.melashvili.formtomysql.controller.entity.Student;
import mvc.melashvili.formtomysql.controller.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student saveStudent(Student student){
        return studentDAO.save(student);
    }

    public Student findStudent(int id){
        Optional<Student> studentOptional = studentDAO.findById(id);
        Student student = studentOptional.get();
        return student;
    }
}
