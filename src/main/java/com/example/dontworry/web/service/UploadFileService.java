package com.example.dontworry.web.service;

import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.uploadFile.UploadFileRepository;

import com.example.dontworry.web.util.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final FileHandler fileHandler;

    private final UploadFileRepository uploadFileRepository;
    public List<UploadFile> addUploadFile(
            List<MultipartFile> files

    ) throws Exception {

        List<UploadFile> list = fileHandler.parseFileBoardPictureInfo(files);


        List<UploadFile> uploadFiles = new ArrayList<>();
        System.out.print(list);
        for(UploadFile uploadFile : list) {
            uploadFiles.add(uploadFileRepository.save(uploadFile));
        }

        return uploadFiles;
    }
}
