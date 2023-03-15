package com.example.dontworry.web.service;

import com.example.dontworry.domain.help.HelpRepository;
import com.example.dontworry.domain.law.LawRepository;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.dto.LawResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LawService {

    private final LawRepository lawRepository;
    public List<LawResDto> findAll(String name){
        return lawRepository.findAll2(name).orElseThrow();
    }
}
