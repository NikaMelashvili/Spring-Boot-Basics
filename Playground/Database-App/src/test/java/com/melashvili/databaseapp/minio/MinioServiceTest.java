package com.melashvili.databaseapp.minio;

import com.melashvili.databaseapp.model.FileResponseDTO;
import com.melashvili.databaseapp.services.MinioService;
import com.melashvili.databaseapp.model.FileUploadRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MinioServiceTest {

    @Autowired
    private MinioService minioService;

    @Test
    public void testUploadTextFile() throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get("C:/Projects/Spring-Boot-Basics/Playground/Database-App/src/test/resources/files/minioTest.xml"));
        FileUploadRequest fileUploadRequest = new FileUploadRequest("testFile", fileContent);
        String result = minioService.uploadTextFile(fileUploadRequest);
        assertEquals("File uploaded successfully.", result);
    }

    @Test
    public void testGetFile() throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get("C:/Projects/Spring-Boot-Basics/Playground/Database-App/src/test/resources/files/minioTest.xml"));
        FileUploadRequest fileUploadRequest = new FileUploadRequest("testFile", fileContent);
        minioService.uploadTextFile(fileUploadRequest);

        FileResponseDTO fileResponseDTO = minioService.getFile(2L);

        assertEquals("testFile", fileResponseDTO.getFileName());
        assertArrayEquals(fileContent, fileResponseDTO.getData());
    }
}
