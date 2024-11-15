package com.melashvili.databaseapp.services;

import com.melashvili.databaseapp.model.FileResponseDTO;
import com.melashvili.databaseapp.model.FileUploadRequest;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class MinioService {

    private MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Autowired
    public void setMinioClient(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public String uploadTextFile(FileUploadRequest fileUploadRequest) {
        try {
            InputStream fileInputStream = new ByteArrayInputStream(fileUploadRequest.getFileContent());

            long fileSize = fileUploadRequest.getFileContent().length;

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileUploadRequest.getFileName())
                            .stream(fileInputStream, fileSize, -1)
                            .contentType("text/plain")
                            .build()
            );
            return "File uploaded successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file to MinIO: " + e.getMessage());
        }
    }

    public FileResponseDTO getFile(Long fileId) {
        try {
            String objectName = "file-" + fileId + ".xml";

            InputStream fileInputStream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build()
            );
            byte[] fileContent = fileInputStream.readAllBytes();
            fileInputStream.close();

            FileResponseDTO fileResponseDTO = new FileResponseDTO();
            fileResponseDTO.setData(fileContent);
            fileResponseDTO.setFileName(objectName);
            fileResponseDTO.setSize(fileContent.length);

            return fileResponseDTO;
        } catch (MinioException e) {
            throw new RuntimeException("Error fetching file from MinIO: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while retrieving the file: " + e.getMessage());
        }
    }
}
