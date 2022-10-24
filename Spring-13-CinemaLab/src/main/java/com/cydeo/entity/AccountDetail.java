package com.cydeo.entity;

import com.cydeo.enums.Role;
import com.cydeo.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accountDetails")
@Data
@NoArgsConstructor
public class AccountDetail extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;
    private int age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    public AccountDetail(String name, String address, String country, String city, State state, int age, String postalCode, Role role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
