package com.cydeo.bootstrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------REGION START-----------------------");

        System.out.println("findByCountry " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryInOrder " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTop2ByCountry " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------------REGION END-----------------------");


    }
}
