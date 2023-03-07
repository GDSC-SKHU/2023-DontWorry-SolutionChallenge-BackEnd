package com.example.dontworry.web.dto;


import com.example.dontworry.domain.user.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PostsReqDto {


    private String title;


    private String category;


    private String mainText;


    private List<MultipartFile> files = new ArrayList<>();


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;


    private String location;
}
