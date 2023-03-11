package com.example.dontworry.web.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @PersistenceContext
    private final EntityManager em;

    @Bean
    public JPAQueryFactory queryFactory(){
        return new JPAQueryFactory(em);
    }
}
