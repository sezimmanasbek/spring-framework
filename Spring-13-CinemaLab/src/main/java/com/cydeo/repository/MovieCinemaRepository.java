package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findMovieCinemaById(BigDecimal id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(BigDecimal id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(BigDecimal id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> getMovieCinemaByDateTimeAfter(LocalDateTime localDateTime);

    //Write a derived query to find the top 3 expensive movies
//    List<MovieCinema> findTop3ByMoviePriceHigher(BigDecimal price);
    List<MovieCinema> findFirst3ByOrderByMoviePriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String prefix);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findMovieCinemaByCinemaLocationName(String location);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT m FROM MovieCinema m WHERE m.dateTime > :dateTime")
    List<MovieCinema> getMovieCinemaByDateTimeHigher(@Param("dateTime") LocalDateTime date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT count(*) FROM movie_cinema WHERE cinema_id = ?1",nativeQuery = true)
    Integer countMovieCinemaByCinemaId(BigDecimal id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id JOIN location l ON c.laction_id = l.id WHERE l.name = ?1",nativeQuery = true)
    List<MovieCinema> getMovieCinemaByLocationName(BigDecimal id);


}
