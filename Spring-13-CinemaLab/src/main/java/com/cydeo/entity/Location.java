package com.cydeo.entity;

import com.cydeo.enums.State;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity {

//   @NotBlank
    private String name;
    private Long latitude;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime longitude;
    private String country;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;
    private String postalCode;
    private String address;

    public Location(String name, Long latitude, LocalDateTime longitude, String country, String city, State state, String postalCode, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}
