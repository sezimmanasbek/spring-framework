package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findMovieByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findMovieByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findMovieByDurationIsIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findMovieByReleaseDateAfter(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findMovieByStateAndType(State state, Type type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> getMovieByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> findAllMovieName();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM movie WHERE name = ?1",nativeQuery = true)
    List<Movie> getMovieByName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Movie> findAllMovieByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duration IN :duration ",nativeQuery = true)
    List<Movie> findMovieByDurationIn(@Param("durations") List<Integer> duration);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5",nativeQuery = true)
    List<Movie> findTop5ExpensiveMovies();

}
