package com.example.dontworry.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class MainResDto {
    private String title;
    private LocalDate createdDate;
    private String storeFileName;
    private String mainText;
    private LocalDate incidentDate;
}
