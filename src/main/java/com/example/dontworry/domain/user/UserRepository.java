package com.example.dontworry.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<User,String> {



    Optional<User> findByUserId(String userId);

    Boolean existsByUserId(String userId);

    List<User> findAll() ;
}
