package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByEmail(String email);
    //Display all employees with first name ' ' and last name ' ' , also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName, String email);

//    Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);
//    Display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String firstName);
//    Display all employees with salaries greater than
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);
//    Display all employees with salaries less than or equals ' '
    List<Employee> findBySalaryLessThanEqual(BigDecimal salary);
//    Display all employees that hired data between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);
//    Display all employees where salaries greater than equals to '' in order desc
    List<Employee> findBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);
//   Display top unique3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(BigDecimal salary);
//   Display employees that don't have email address
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'sdubber7@t-online.de'" )
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary = ?2")
    Employee getEmployeeDetail(String email, int salary);



}
