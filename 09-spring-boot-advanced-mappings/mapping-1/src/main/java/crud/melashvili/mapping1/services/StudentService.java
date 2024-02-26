package crud.melashvili.mapping1.services;

import crud.melashvili.mapping1.dao.StudentDAO;
import crud.melashvili.mapping1.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public void addStudent(Student student){
        studentDAO.save(student);
    }

    public Student getStudentById(int id){
        Student student = studentDAO.findById(id).get();
        return student;
    }

    public void updateStudent(int id){
        Student student = studentDAO.findById(id).get();
        student.setFirstName("Archili");
        studentDAO.save(student);
    }

    public void deleteStudent(int id){
        Student student = studentDAO.findById(id).get();
        studentDAO.delete(student);
    }
}
