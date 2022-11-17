package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Cinema getCinemaByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String prefix);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findCinemaByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findCinemaByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id = ?1")
    String getAccountNameById(BigDecimal id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c JOIN location l ON c.location_id = l.id WHERE l.country = ?1",nativeQuery = true)
    List<Cinema> getCinemaByLocation(@Param("location") String location);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM ciname c WHERE name like concat('%', ?1, '%') OR sponsored_name ILIKE  concat('%', ?1, '%')",nativeQuery = true)
    List<Cinema> getCinemaByNameOOrSponsoredNameContaining(String prefix);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM ciname ORDER BY name",nativeQuery = true)
    List<Cinema> getAllAccountsOrderByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct(*) FROM cinema WHERE sponsoredName = :sponsoredName",nativeQuery = true)
    List<Cinema> getDistinctAccountBySponsoredName(@Param("sponsoredName") String sponsoredName);

}
