package com.example.dontworry.web.dto;

//import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.uploadFile.UploadFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsResDto {
    private String title;
    private List<Category> category=new ArrayList<>();
    private String mainText;
    private String userId;
    private String location;
    private List<UploadFile> files =new ArrayList<>();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

}
