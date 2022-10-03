package com.cydeo.repository;

import com.cydeo.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Mime","IT",55);
        return employee.getHourlyRate();
    }
}
