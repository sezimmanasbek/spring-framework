package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    User findByEmail(String email);

    //Write a derived query to read a user with an username?
    List<User> findUserByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountDetailsNameContaining(String prefix);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccountDetailsNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountDetailsAgeGreaterThan(int age);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    List<User> findUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    List<User> getUserByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> getAllUser();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user u JOIN account_details ad ON u.account_details.id = ad.id WHERE ad.name LIKE concat('%?prefix%')", nativeQuery = true)
    List<User> getAllUserByNameContaining(@Param("prefix") String prefix);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> getAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user u JOIN account_details ad ON u.account_details_id ad.id WHERE ad.age IN ?age", nativeQuery = true)
    List<User> getUserAgeBetween(@Param("age") List<Integer> age);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user WHERE email = ?email", nativeQuery = true)
    List<User> findUsersByEmail(@Param("email") String email);

}
