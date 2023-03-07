package com.example.dontworry.web.dto;

import com.example.dontworry.domain.uploadFile.UploadFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsResDto {
    private String title;
    private String category;
    private String mainText;
    private String userId;
    private String location;
    private List<UploadFile> imagesFiles;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

}
