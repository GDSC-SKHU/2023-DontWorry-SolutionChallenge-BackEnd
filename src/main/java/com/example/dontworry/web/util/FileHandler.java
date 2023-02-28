package com.example.dontworry.web.util;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.uploadFile.UploadFileRepository;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FileHandler {

    private final Storage storage;

    @Autowired
    private UploadFileRepository uploadFileRepository;
    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;



    public List<UploadFile> parseFileBoardPictureInfo(
            Posts posts,
            List<MultipartFile> multipartFiles
    ) throws Exception{
        // 반환을 할 파일 리스트
        List<UploadFile> fileList = new ArrayList<>();

        // 파일이 빈 것이 들어오면 빈 것을 반환
        if(multipartFiles.isEmpty()){
            return fileList;
        }

        // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());



        // 경로를 지정하고 그곳에다가 저장할 심산이다
        String path = "images/" + current_date;
        File file = new File(path);

        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if(!file.exists()){
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        // 파일들을 이제 만져볼 것이다
        for (MultipartFile multipartFile : multipartFiles){
            // 파일이 비어 있지 않을 때 작업을 시작해야 오류가 나지 않는다
            if(!multipartFile.isEmpty()){
                // jpeg, png, gif 파일들만 받아서 처리할 예정
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
                if (ObjectUtils.isEmpty(contentType)){
                    break;
                }
                else{
                    if(contentType.contains("image/jpeg")){
                        originalFileExtension = ".jpg";
                    }
                    else if(contentType.contains("image/png")){
                        originalFileExtension = ".png";
                    }
                    else if(contentType.contains("image/gif")){
                        originalFileExtension = ".gif";
                    }
                    // 다른 파일 명이면 아무 일 하지 않는다
                    else{
                        break;
                    }
                }
                // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
                String new_file_name = System.nanoTime() + originalFileExtension;

                BlobInfo blobInfo = storage.createFrom(
                        BlobInfo.newBuilder(bucketName, path + "/" + new_file_name)
                                .setContentType(multipartFile.getContentType())
                                .build(),
                        multipartFile.getInputStream()
                );
                // 생성 후 리스트에 추가
                UploadFile uploadFile = UploadFile.builder()
                        .uploadFileName(multipartFile.getOriginalFilename())
                        .storeFileName(blobInfo.getMediaLink())
                        .file_size(multipartFile.getSize())
                        .posts(posts)
                        .build();
                fileList.add(uploadFile);

                multipartFile.getInputStream().close();
            }
        }

        return fileList;
    }

}
