package com.example.dontworry.web.dto;

import com.example.dontworry.domain.punishment.Punishment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LawResDto {
    private String form;
    private String policy;
    private String lawName;
    private List<String> punishments;
    private String resolutionProcedures;
//    private String countryName;

}