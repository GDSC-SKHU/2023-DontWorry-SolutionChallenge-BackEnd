package com.example.dontworry.web.dto;

//import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsReqDto {

    private String title;
    private List<String> category ;

    private String mainText;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

    private String location;
    private List<MultipartFile> files ;



}
