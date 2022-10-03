package com.cydeo.stereotype_annotations.Model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataStructure {
    ExtraHours extraHours;
    public void getTotalHours(){
        System.out.println("Total hours: " + (40 +extraHours.getHours()));
    }
}
