package com.example.demo.studedent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudedentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudedentRepository repository) {
        return args -> {
            Studedent lutendo = new Studedent(
                    "Lutendo",
                    "lutendo@gmail.com",
                    LocalDate.of(1995, Month.DECEMBER, 20)
            );
            Studedent zwothe = new Studedent(
                    "zwothe",
                    "zwothe@gmail.com",
                    LocalDate.of(2010, Month.OCTOBER, 25)
            );

            repository.saveAll(
                    List.of(lutendo, zwothe)
            );
        };
    }
}
