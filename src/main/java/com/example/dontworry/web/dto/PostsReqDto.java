package com.example.dontworry.web.dto;

//import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.uploadFile.UploadFile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostsReqDto {

    private String title;
    private List<Category> category;

    private String mainText;
    private LocalDate incidentDate;

    private String location;



}
