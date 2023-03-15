package com.example.dontworry.web.service;

import com.example.dontworry.domain.uploadFile.UploadFile;
import com.example.dontworry.domain.uploadFile.UploadFileRepository;

import com.example.dontworry.web.util.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFileService {
    @Autowired
    private FileHandler fileHandler;
    @Autowired
    private UploadFileRepository uploadFileRepository;
    public List<UploadFile> addUploadFile(
            List<MultipartFile> files

    ) throws Exception {
        // 파일을 저장하고 그 BoardPicture 에 대한 list 를 가지고 있는다
        List<UploadFile> list = fileHandler.parseFileBoardPictureInfo(files);

        List<UploadFile> uploadFiles = new ArrayList<>();
        for(UploadFile uploadFile : list) {
            uploadFiles.add(uploadFileRepository.save(uploadFile));
        }

        return uploadFiles;
    }
}
