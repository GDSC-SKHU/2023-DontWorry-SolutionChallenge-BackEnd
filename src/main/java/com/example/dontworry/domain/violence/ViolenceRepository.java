package com.example.dontworry.domain.violence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolenceRepository extends JpaRepository<Violence,String> {
}
