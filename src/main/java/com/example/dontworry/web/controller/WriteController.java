package com.example.dontworry.web.controller;


import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import com.example.dontworry.web.dto.PostsReqDto;
import com.example.dontworry.web.dto.PostsResDto;
import com.example.dontworry.web.service.CategoryService;
import com.example.dontworry.web.service.PostService;
import com.example.dontworry.web.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class WriteController {


    private final UploadFileService uploadFileService;



    private final PostService postService;

    private final CategoryService categoryService;

    @PostMapping("/write")
    public ResponseEntity<?> write(
            @Valid @ModelAttribute PostsReqDto reqDto,
            @Login User loginMember
    ) throws Exception {

        System.out.println("abs"+reqDto.getFiles());
        List<UploadFile> uploadFiles = new ArrayList<>();
        List<MultipartFile> multipartFiles = new ArrayList<>();
        if (reqDto.getFiles() ==null){
            uploadFiles = uploadFileService.addUploadFile(multipartFiles) ;
        } else {
            uploadFiles = uploadFileService.addUploadFile(reqDto.getFiles());
        }

        List<Category> categories = categoryService.addCategory(reqDto.getCategory());
        Posts posts = postService.addPosts(Posts.builder()
                .user(loginMember)
                .title(reqDto.getTitle())
                .category(categories)
                .mainText(reqDto.getMainText())
                .incidentDate(reqDto.getIncidentDate())
                .location(reqDto.getLocation())
                .files(uploadFiles)
                .build());

        PostsResDto postsResDto = PostsResDto.builder()
                .userId(loginMember.getUserId())
                .title(posts.getTitle())
                .category(posts.getCategory())
                .mainText(posts.getMainText())
                .location(posts.getLocation())
                .files(posts.getFiles())
                .incidentDate(posts.getIncidentDate())
                .build();




        return ResponseEntity.ok().body(postsResDto);
    }





}
