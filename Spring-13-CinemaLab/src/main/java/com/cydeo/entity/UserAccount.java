package com.cydeo.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity {

    @NotNull
    private String email;
    @NotNull
//    @Size(min=6)
    private String password;
    private String username;

    @OneToOne
    private AccountDetail accountDetails;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
