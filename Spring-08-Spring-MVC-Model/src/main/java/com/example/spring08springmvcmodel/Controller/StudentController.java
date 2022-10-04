package com.example.spring08springmvcmodel.Controller;

import com.example.spring08springmvcmodel.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");
        String subject = "Collections";
        model.addAttribute("subject",subject);
         int studentID = new Random().nextInt();
        model.addAttribute("id",studentID);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(5);
        numbers.add(12);
        numbers.add(25);
        numbers.add(100);
        model.addAttribute("list",numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);
        return "student/welcome";
    }
}
