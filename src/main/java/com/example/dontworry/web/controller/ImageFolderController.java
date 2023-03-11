package com.example.dontworry.web.controller;


import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import com.example.dontworry.web.dto.ImageFolderResDto;
import com.example.dontworry.web.service.ImageFolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
@RequestMapping
public class ImageFolderController {

    private final ImageFolderService imageFolderService;

    @GetMapping("/images")
    public ResponseEntity<?> imageFolders(@Login User loginMember) {
        List<String> incidentDates = imageFolderService.findByIncidentDate(loginMember);

        ImageFolderResDto imageFolderResDto = ImageFolderResDto.builder()
                .incidentDate(incidentDates)
                .build();
        List<String> newList = imageFolderResDto.getIncidentDate().stream().distinct().collect(Collectors.toList());

        return ResponseEntity.ok().body(newList);
    }

    @GetMapping("/images/{inputDate}")
    public ResponseEntity<?> images(@Login User loginMember,
                                    @PathVariable("inputDate") @DateTimeFormat(pattern = "yy-MM") Date  incidentDate){

        List<String> images = imageFolderService.findByImages(incidentDate,loginMember);

        return ResponseEntity.ok().body(images);
    }

//    @GetMapping("/localdate/{value}")
//    public ResponseEntity<?> localDate(
//            @PathVariable("value")
//            @DateTimeFormat(pattern = "yy-MM") Date localDate) {
//
//        return ResponseEntity.ok().body(localDate.getYear());
//    }
}