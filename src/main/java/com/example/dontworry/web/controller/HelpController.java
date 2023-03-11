package com.example.dontworry.web.controller;

import com.example.dontworry.domain.help.Help;
import com.example.dontworry.web.dto.HelpResDto;
import com.example.dontworry.web.service.HelpService;
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
public class HelpController {

    private final HelpService helpService;
    @GetMapping("/help/{name}")
    public ResponseEntity<?> findAll1(@PathVariable String name){
        List<HelpResDto> result = helpService.findAll(name);
        return ResponseEntity.ok().body(result);
    }
}
