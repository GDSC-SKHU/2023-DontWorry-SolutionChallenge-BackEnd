package com.example.dontworry.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class HelpResDto {
    private String number;
    private String summary;
    private String countryName;

}