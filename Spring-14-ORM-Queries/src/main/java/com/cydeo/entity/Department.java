//package com.cydeo.enity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "departments")
//@Data
//@NoArgsConstructor
//public class Department{
//
//    @Id
//    private String department;
//    private String division;
//}
package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private String department;
    private String division;
}