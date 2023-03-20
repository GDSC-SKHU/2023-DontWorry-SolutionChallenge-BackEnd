package com.example.dontworry.web.util;

import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.uploadFile.UploadFile;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileHandler {

    private final Storage storage;


    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;



    public List<UploadFile> parseFileBoardPictureInfo(
            List<MultipartFile> multipartFiles
    ) throws Exception{
        List<UploadFile> fileList = new ArrayList<>();

        if(multipartFiles.isEmpty()){
            return fileList;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());




        String path = "images/" + current_date;
        File file = new File(path);

        if(!file.exists()){
            file.mkdirs();
        }


        for (MultipartFile multipartFile : multipartFiles){
            if(!multipartFile.isEmpty()){


                String uuid = UUID.randomUUID().toString();
                String new_file_name = uuid ;

                BlobInfo blobInfo = storage.createFrom(
                        BlobInfo.newBuilder(bucketName, path + "/" + new_file_name)
                                .setContentType(multipartFile.getContentType())
                                .build(),
                        multipartFile.getInputStream()
                );
                String link = "https://storage.googleapis.com/"+ bucketName +"/"+ path +"/"+ new_file_name  ;

                UploadFile uploadFile = UploadFile.builder()
                        .uploadFileName(multipartFile.getOriginalFilename())
                        .storeFileName(link)
                        .file_size(multipartFile.getSize())

                        .build();
                fileList.add(uploadFile);

                multipartFile.getInputStream().close();
            }
        }

        return fileList;
    }

}
