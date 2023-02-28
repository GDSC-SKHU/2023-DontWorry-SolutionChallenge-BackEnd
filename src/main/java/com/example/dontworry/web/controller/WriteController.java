package com.example.dontworry.web.controller;


import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import com.example.dontworry.web.service.PostService;
import com.example.dontworry.web.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class WriteController {


    @Autowired
    private UploadFileService uploadFileService;


    @Autowired
    private PostService postService;


    @PostMapping("/write")
    public ResponseEntity<?> saveItem(
            @Valid @RequestParam("files") List<MultipartFile> files,
            @Valid @RequestParam("title") String title,
            @Valid @RequestParam("category") String category,
            @Valid @RequestParam("mainText") String mainText,
            @Valid @RequestParam("location") String Location,
            @Valid @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @Login User loginMember
    ) throws Exception {
        Posts posts = postService.addPosts(Posts.builder()
                .user(loginMember)
                .title(title)
                .category(category)
                .mainText(mainText)
                .incidentDate(date)
                .location(Location)
                .build());

        uploadFileService.addBoardPictures(posts,files);




        return ResponseEntity.ok().body("ok");
    }




}
