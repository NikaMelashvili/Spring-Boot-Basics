package mvc.melashvili.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "showform";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
}
