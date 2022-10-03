package com.cydeo;

import com.cydeo.config.ConfigApp;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        SalaryService ss =  context.getBean(SalaryService.class);
        ss.calculateRegularySalary();
    }
}
