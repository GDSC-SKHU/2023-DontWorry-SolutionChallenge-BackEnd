package com.example.dontworry.web.controller;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import com.example.dontworry.web.dto.MainResDto;
import com.example.dontworry.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MainController {
    private final PostService postService;
    @GetMapping("/main")
    public ResponseEntity<?> posts(@Login User user){
        List<MainResDto> posts = postService.findAllByUser(user);
        return ResponseEntity.ok().body(posts);
    }
}
