package com.example.dontworry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DontWorryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DontWorryApplication.class, args);
    }

}
