package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataGenerator implements CommandLineRunner {
    RegionRepository regionRepository;
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------REGION START-----------------------");

        System.out.println("findByCountry " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryInOrder " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTop2ByCountry " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------------REGION END-----------------------");

        System.out.println("-----------------------DEPARTMENT START-----------------------");

        System.out.println("findByDepartment " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findByDivisionEquals " + departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains " + departmentRepository.findDistinctTop3ByDivisionContains("Outdoors"));

        System.out.println("-----------------------DEPARTMENT END-----------------------");

        System.out.println("-----------------EMPLOYEE START-----------------");

        System.out.println("getEmployeeDetail:" + employeeRepository.findByEmailIsNull());
        System.out.println("getEmployeeSalary:" + employeeRepository.findByEmail("@cydeo.com"));
        System.out.println("getEmployeeDetail:" + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary:" + employeeRepository.getEmployeeSalary());
        System.out.println("getEmployeeSalary:" + employeeRepository.getEmployeeDetail("sdubber7@t-online.de").get());
        System.out.println("getEmployeeSalary:" + employeeRepository.getEmployeeDetail("sdubber7@t-online.de",123));


        System.out.println("-----------------EMPLOYEE  END-----------------");

    }
}
