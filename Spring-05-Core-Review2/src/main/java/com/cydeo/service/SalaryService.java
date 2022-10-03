package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.DBEmployeeRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import com.cydeo.repository.RegularHours;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class SalaryService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    @Autowired
    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("overtimeHours") HoursRepository hoursRepository){
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }
    public void calculateRegularySalary(){
        System.out.println("Salary : " + (employeeRepository.getHourlyRate() * hoursRepository.getHours()));
    }
}
