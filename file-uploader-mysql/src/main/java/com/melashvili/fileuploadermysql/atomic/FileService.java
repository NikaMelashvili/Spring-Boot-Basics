package com.melashvili.fileuploadermysql.atomic;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final ChildFileRepository fileRepository;

    public FileService(ChildFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public String renameFileWithTransaction(NewFileName newFileName) throws IOException {
        Path oldFilePath = Paths.get(newFileName.getDirectoryPath(), newFileName.getOldFilename());
        Path newFilePath = Paths.get(newFileName.getDirectoryPath(), newFileName.getNewFilename());

        // 1. Rename file locally
        try {
            Files.move(oldFilePath, newFilePath);
        } catch (IOException e) {
            throw new IOException("Failed to rename file locally.", e);
        }

        // 2. Update database entry
        int rowsUpdated = fileRepository.updateFilename(newFileName.getOldFilename(),
                newFileName.getOldFilename(), newFileName.getDirectoryPath());
        if (rowsUpdated == 0) {
            throw new RuntimeException("Failed to update database entry.");
        }
        return "Both the filename and database were altered successfully.";
    }

}
