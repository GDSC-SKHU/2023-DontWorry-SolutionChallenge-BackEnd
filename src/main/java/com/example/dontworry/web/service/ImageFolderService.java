package com.example.dontworry.web.service;

import com.example.dontworry.domain.posts.PostsRepository;
import com.example.dontworry.domain.uploadFile.UploadFileRepository;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.ImageFolderResDto;
import com.example.dontworry.web.dto.ImageFolderResDto;
import com.example.dontworry.web.dto.ImageResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageFolderService {

    private final PostsRepository postsRepository;
    private final UploadFileRepository uploadFileRepository;
    public List<String> findByIncidentDate(User user1){
        List<LocalDate> localDates = postsRepository.findByIncidentDate(user1).orElseThrow();
        List<LocalDate> newList = localDates.stream().distinct().collect(Collectors.toList());

        List<String> formattedDates = new ArrayList<>();
        for(LocalDate  incidentDate : newList){
            String formattedDate = incidentDate.format(DateTimeFormatter.ofPattern("yy-MM"));
            formattedDates.add(formattedDate);
        }

        return formattedDates;
    }

    public List<ImageResDto> findByImages(Date incidentDate, User user){
        List<ImageResDto> imageResDtos = uploadFileRepository.findByImages(incidentDate, user).orElseThrow();
        List<ImageResDto> result = new ArrayList<>();
        for(ImageResDto i : imageResDtos){
            ImageResDto imageResDto = ImageResDto.builder()
                    .uploadFileName(i.getUploadFileName())
                    .storeFileName(i.getStoreFileName())
                    .build();
            result.add(imageResDto);
        }

        return result;
    }


}
