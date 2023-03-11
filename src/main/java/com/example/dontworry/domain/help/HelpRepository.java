package com.example.dontworry.domain.help;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelpRepository extends JpaRepository<Help, Long>, HelpRepositoryCustom {

}


