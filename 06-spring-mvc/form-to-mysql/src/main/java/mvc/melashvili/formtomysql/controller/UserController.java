package mvc.melashvili.formtomysql.controller;

import jakarta.servlet.http.HttpServletRequest;
import mvc.melashvili.formtomysql.controller.entity.Student;
import mvc.melashvili.formtomysql.controller.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {

    private final StudentService studentService;

    @Autowired
    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/addForm")
    public String showAddForm() {
        return "submitform";
    }

    @PostMapping("/add")
    public String addData(HttpServletRequest request, Model model) {
        String name = request.getParameter("first_name");
        String ageValue = request.getParameter("age");
        int age = 0;
        try{
            age = Integer.parseInt(ageValue);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        Student student = addStudent(name, age);

        model.addAttribute("Student", student.getId());
        return "submitform";
    }

    private Student addStudent(String name, int age) {
        Student student = new Student(name, age);
        System.out.println("Student saved successfully");
        return studentService.saveStudent(student);
    }

    private Student getStudentById(int id){
        return studentService.findStudent(id);
    }
}


