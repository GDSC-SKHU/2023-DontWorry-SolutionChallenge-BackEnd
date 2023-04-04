package com.example.dontworry.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class ImageResDto {
    private String storeFileName;
    private String uploadFileName;


}
