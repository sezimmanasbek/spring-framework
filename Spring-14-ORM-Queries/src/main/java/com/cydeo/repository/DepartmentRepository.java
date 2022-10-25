package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;;

import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, String> {

    List<Department> findByDepartment(String department);

    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    List<Department> findDistinctTop3ByDivisionContains(String division);
}
