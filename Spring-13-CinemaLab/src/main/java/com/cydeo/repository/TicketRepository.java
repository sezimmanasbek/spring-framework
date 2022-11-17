package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);


    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime1);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t  WHERE t.userAccount.id = :id")
    List<Ticket> fetchAllTicketByUserAccount(Long id);


    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN :date1 AND :date2")
    List<Ticket> getTicketByDateBetween(@Param("date") LocalDateTime date1,@Param("date2") LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(t) FROM Ticket t  WHERE t.userAccount.id = ?1",nativeQuery = true)
    Integer countTicketByUser(@Param("userId")Long userId);


    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count(*) FROM ticket WHERE user_account_id = :userId AND date_time BETWEEN :date1 AND :date2",nativeQuery = true)
    Integer countTicketByUserSpecificDate(@Param("userId") Long id,@Param("date1") LocalDateTime date1,@Param("date2") LocalDateTime date2);


    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT distinct(m.name) FROM ticket t JOIN  movie_cinema mc ON t.movie_cinema-id = mc.id JOIN movie m ON mc.movie_id = m.id ", nativeQuery = true)
    List<Ticket> getDistinctByMovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id WHERE u.email = :email",nativeQuery = true)
    List<Ticket> getTicketByEmail(@Param("email") String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> findAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id JOIN account_details ad ON u.account_details_id = ad.id " +
            "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id JOIN movie m ON mc.movie_id = m.id " +
            "WHERE u.username ILIKE concat('%' + ?1 + '%') OR m.name ILIKE concat('%'+?1+'%') OR ad.name ILIKE concat('%' + ?1 + '%)'",nativeQuery = true)
    List<Ticket> findTicketByUsernameContainingOrMovieNameContaining(String prefix);

}