package com.example.dontworry.domain.law;

import com.example.dontworry.domain.help.Help;
import com.example.dontworry.domain.help.HelpRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawRepository extends JpaRepository<Law, Long>, LawRepositoryCustom {

}


