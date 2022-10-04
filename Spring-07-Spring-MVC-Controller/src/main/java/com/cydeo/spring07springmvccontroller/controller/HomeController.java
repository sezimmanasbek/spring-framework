package com.cydeo.spring07springmvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotate the class with @Controller stereotype annotation
public class HomeController {

    @RequestMapping("/home") // Use @RequestMapping annotation to associate the action with an HTTP request path
    public String home(){
        return "home.html"; // return the HTTP document name that contains the details we want the browser to display
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }
}
