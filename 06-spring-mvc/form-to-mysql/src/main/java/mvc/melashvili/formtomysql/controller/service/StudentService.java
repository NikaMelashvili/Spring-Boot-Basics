package mvc.melashvili.formtomysql.controller.service;

import mvc.melashvili.formtomysql.controller.entity.Student;
import mvc.melashvili.formtomysql.controller.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void saveStudent(Student student){
        studentDAO.save(student);
    }
}
