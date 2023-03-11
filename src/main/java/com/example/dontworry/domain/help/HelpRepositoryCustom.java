package com.example.dontworry.domain.help;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.dto.MainResDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HelpRepositoryCustom {

    Optional<List<HelpResDto>> findAll1(String name);
}
