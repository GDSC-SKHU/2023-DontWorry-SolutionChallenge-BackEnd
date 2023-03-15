package com.example.dontworry.domain.posts;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;

public interface PostsRepositoryCustom {
    Optional<List<LocalDate>> findByIncidentDate(User user);

    Optional<MainResDto> findAllByUser(User user,Long id);

    Optional<List<Long>> SearchAllById(User user);

    Optional<List<Long>> SearchAllByIdAndCategory(User user,String category);
    Optional<List<Long>> SearchAllByIdAndTitle(User user,String title);
}
