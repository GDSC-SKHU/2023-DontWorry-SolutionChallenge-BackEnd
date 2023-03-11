package com.example.dontworry.domain.uploadFile;

import com.example.dontworry.domain.user.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UploadFileRepositoryCustom {

    Optional<List<String>> findByImages(Date incidentDate, User user);

}
