package com.example.dontworry.web.service;

import com.example.dontworry.domain.help.Help;
import com.example.dontworry.domain.help.HelpRepository;
import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.web.dto.HelpResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelpService {

    private final HelpRepository helpRepository;
    public List<HelpResDto> findAll(String name){
        return helpRepository.findAll1(name).orElseThrow();
    }
}
