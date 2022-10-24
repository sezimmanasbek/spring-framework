package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private int duration;
    @Column(columnDefinition = "text")
    private String summary;

    @ManyToMany
    @JoinTable(name = "movieGenreRel")
    private List<Genre> genre;

    public Movie(String name, BigDecimal price, Type type, State state, LocalDate releaseDate, int duration, String summary) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
    }
}
