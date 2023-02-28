package com.example.dontworry.domain.uploadFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile,Long> {
    UploadFile save(UploadFile uploadFile);
    Optional<UploadFile> findById(Long id);



}
