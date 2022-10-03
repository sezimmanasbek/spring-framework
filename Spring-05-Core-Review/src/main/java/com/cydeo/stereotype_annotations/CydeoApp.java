package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.Config.ConfigApp;
import com.cydeo.stereotype_annotations.Model.DataStructure;
import com.cydeo.stereotype_annotations.Model.Microservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Microservice ms = context.getBean(Microservice.class);
        DataStructure ds = context.getBean(DataStructure.class);

        ds.getTotalHours();
        ms.getTotalHours();
    }
}
