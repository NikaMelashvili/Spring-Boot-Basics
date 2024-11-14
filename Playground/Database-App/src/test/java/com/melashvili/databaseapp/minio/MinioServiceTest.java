package com.melashvili.databaseapp.minio;

import com.melashvili.databaseapp.services.MinioService;
import com.melashvili.databaseapp.model.FileUploadRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MinioServiceTest {

    @Autowired
    private MinioService minioService;

    @Test
    public void testUploadTextFile() throws IOException {
        // Prepare a test file upload request
        byte[] fileContent = Files.readAllBytes(Paths.get("C:/Projects/Spring-Boot-Basics/Playgound/Database-App/src/test/resources/files/minioTest.xml"));
        FileUploadRequest fileUploadRequest = new FileUploadRequest("testFile.txt", fileContent);

        // Call the upload method
        String result = minioService.uploadTextFile(fileUploadRequest);

        // Assert that the upload was successful
        assertEquals("File uploaded successfully.", result);
    }
}
