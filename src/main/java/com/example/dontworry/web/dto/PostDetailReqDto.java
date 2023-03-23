package com.example.dontworry.web.dto;

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
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostDetailReqDto {
    private String title;

    private List<String> categoryName = new ArrayList<>();
    private String mainText;
    private String location;
    private List<String> storeFileName= new ArrayList<>();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private Long id;
}
