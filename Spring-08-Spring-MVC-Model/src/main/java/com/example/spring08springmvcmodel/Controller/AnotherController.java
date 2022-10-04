package com.example.spring08springmvcmodel.Controller;

import com.example.spring08springmvcmodel.enums.Gender;
import com.example.spring08springmvcmodel.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {

    @RequestMapping("/list")
    public String mentor(Model model){
        List<Mentor> mentors = new ArrayList<>();
        Mentor mentor = new Mentor("Samat","Kasymov",24, Gender.MALE);
        Mentor mentor1 = new Mentor("Mike","Smith",45,Gender.MALE);
        Mentor mentor2 = new Mentor("Tom","Hanks",65,Gender.MALE);
        Mentor mentor3 = new Mentor("Ammy","Bryan",25,Gender.FEMALE);
        mentors.add(mentor);
        mentors.add(mentor1);
        mentors.add(mentor2);
        mentors.add(mentor3);
        model.addAttribute("mentor",mentors);


        return "student/mentor";
    }
}
