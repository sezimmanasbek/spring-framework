package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

     List<Region> findByCountry(String country); // select * from region Where country==Canada

     List<Region> findDistinctByCountry(String country);

     List<Region> findByCountryContaining(String prefix);

     List<Region> findByCountryContainingOrderByCountry(String prefix);
     List<Region> findTop2ByCountry(String country);


}
