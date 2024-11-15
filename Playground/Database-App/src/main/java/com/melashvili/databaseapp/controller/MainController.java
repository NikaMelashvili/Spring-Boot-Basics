package com.melashvili.databaseapp.controller;

import com.melashvili.databaseapp.model.FileResponseDTO;
import com.melashvili.databaseapp.model.FileUploadRequest;
import com.melashvili.databaseapp.services.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/minio")
public class MainController {

    private MinioService minioService;

    @Autowired
    public void setMinioService(MinioService minioService) {
        this.minioService = minioService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFile(@RequestBody FileUploadRequest fileUploadRequest) {
        String response = minioService.uploadTextFile(fileUploadRequest);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get")
    public ResponseEntity<FileResponseDTO> getFile(@RequestParam("id") Long fileId) {
        FileResponseDTO response = minioService.getFile(fileId);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
