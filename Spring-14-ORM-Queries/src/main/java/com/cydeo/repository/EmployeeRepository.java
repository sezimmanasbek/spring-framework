package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEquals(int salary);

//    like, contains, startsWith, endsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String firstName);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //before
    @Query("SELECT e FROM Employee e WHERE e.hireDate  > ?1")
    List<Employee> getEmployeeHireDateBetween(LocalDate date);

    //between
    @Query("SELECT e FROM Employee e WHERE e.hireDate BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeHireDateBetween(LocalDate date,LocalDate LocalDate2);

    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeEmailIsNull(String email);

    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull(String email);


    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrder();

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM employees WHERE salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id=:id")
            void updateEmployeeJPQL(@Param("id")Long id);

    @Modifying
    @Transactional
    @Query(value ="UPDATE employees  SET email = 'admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNative(@Param("id")Long id);

    List<Employee> retrieveDepartmentByDivision(String division);

}
