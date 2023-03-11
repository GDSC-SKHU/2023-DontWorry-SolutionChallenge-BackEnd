package com.example.dontworry.domain.posts;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.ImageFolderResDto;

public interface PostsRepositoryCustom {
    Optional<List<LocalDate>> findByIncidentDate(User user);



}
