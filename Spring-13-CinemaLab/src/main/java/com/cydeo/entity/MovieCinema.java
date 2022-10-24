package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{


    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @OneToOne
    private Movie movie;
    @OneToOne
    private Cinema cinema;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
