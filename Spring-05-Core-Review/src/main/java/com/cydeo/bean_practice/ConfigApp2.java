package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp2 {

    @Bean(name = "message1")
    public String welcome(){
        return "Welcome to CydeoApp";
    }

    @Bean(name = "message2")
    public String springCore(){
        return "Spring Core Practice";
    }
}
