package com.example.dontworry.web.controller;

import com.example.dontworry.web.dto.LawResDto;
import com.example.dontworry.web.service.LawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LawController {

    private final LawService lawService;
    @GetMapping("/law/{name}")
    public ResponseEntity<?> findAll2(@PathVariable String name){
        List<LawResDto> result = lawService.findAll(name);

        return ResponseEntity.ok().body(result);
    }
}
