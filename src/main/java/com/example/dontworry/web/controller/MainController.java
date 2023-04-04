package com.example.dontworry.web.controller;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import com.example.dontworry.web.dto.MainResDto;
import com.example.dontworry.web.dto.PostDetailReqDto;
import com.example.dontworry.web.service.PostService;
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
public class MainController {
    private final PostService postService;
    @GetMapping("/main")
    public ResponseEntity<?> main(@Login User user){
        List<MainResDto> posts = postService.findAllByUser(user);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/main/category/{category}")
    public ResponseEntity<?> mainByCategory(@Login User user,@PathVariable String category){
        List<MainResDto> posts = postService.searchAllByIdAndCategory(user,category);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/main/title/{title}")
    public ResponseEntity<?> mainByTitle(@Login User user,@PathVariable String title){

        List<MainResDto> posts = postService.searchAllByIdAndTitle(user,title);

        return ResponseEntity.ok().body(posts);
    }
    @GetMapping(value = {"/main/title","/main/category"})
    public ResponseEntity<?> all(@Login User user){
        List<MainResDto> posts = postService.findAllByUser(user);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/main/detail/{id}")
    public ResponseEntity<?> mainById(@Login User user, @PathVariable("id") Long id){
        PostDetailReqDto posts = postService.searchById(user,id);
        return ResponseEntity.ok().body(posts);
    }
}
