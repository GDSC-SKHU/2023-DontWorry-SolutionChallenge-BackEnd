package com.example.dontworry.domain.uploadFile;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.ImageResDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UploadFileRepositoryCustom {

    Optional<List<ImageResDto>> findByImages(Date incidentDate, User user);

}
