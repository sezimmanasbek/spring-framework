package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {
//    find all courses by category
    List<Course> findByCategory(String category);

//    find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

//    checks if a course with provided name is exists. return true or false
    Boolean existsByName(String name);

// count course by category
    Integer countByCategory(String category);

//    find all courses that start with the provided courses name
    List<Course> findByNameStartingWith(String name);

//    find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> findAllCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating")int rating);

}
