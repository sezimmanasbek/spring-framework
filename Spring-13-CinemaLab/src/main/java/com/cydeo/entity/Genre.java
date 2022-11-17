package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre extends BaseEntity{

    private String name;

   @ManyToMany(mappedBy = "genre")
    private List<Movie> movie;

    public Genre(String name) {
        this.name = name;
    }
}
