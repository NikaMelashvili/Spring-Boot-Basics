package com.melashvili.fileuploadermysql.atomic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FileServiceTest {

    @Mock
    private ChildFileRepository fileRepository;

    @InjectMocks
    private FileService fileService;

    @TempDir
    Path tempDir;

    private NewFileName newFileName;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        // Create a temporary old file to rename
        Path oldFile = tempDir.resolve("dzveli.txt");
        Files.createFile(oldFile);

        // Set up the NewFileName object
        newFileName = new NewFileName();
        newFileName.setOldFilename("dzveli.txt");
        newFileName.setNewFilename("axali.txt");
        newFileName.setDirectoryPath(tempDir.toString());
    }

    @Test
    public void testRenameFileWithTransaction() throws IOException {
        // Mock the repository update behavior
        when(fileRepository.updateFilename("dzveli.txt", "axali.txt", tempDir.toString())).thenReturn(1);

        // Run the rename method
        String result = fileService.renameFileWithTransaction(newFileName);

        // Check that the file was renamed
        Path newFilePath = tempDir.resolve("axali.txt");
        assertTrue(Files.exists(newFilePath), "New file should exist after renaming");

        // Verify the return message and database update call
        assertEquals("Both the filename and database were altered successfully.", result);
        verify(fileRepository, times(1)).updateFilename("dzveli.txt", "axali.txt", tempDir.toString());
    }

    @Test
    public void testRenameFileWithTransaction_FailureInRepository() throws IOException {
        // Simulate repository update failure by returning 0
        when(fileRepository.updateFilename("dzveli.txt", "axali.txt", tempDir.toString())).thenReturn(0);

        // Run the rename method and expect an exception due to repository failure
        try {
            fileService.renameFileWithTransaction(newFileName);
        } catch (RuntimeException e) {
            assertEquals("Failed to update database entry.", e.getMessage());
        }

        // Check that the file was renamed locally despite database update failure
        Path newFilePath = tempDir.resolve("axali.txt");
        assertTrue(Files.exists(newFilePath), "New file should exist after renaming");

        // Verify that repository update was attempted once
        verify(fileRepository, times(1)).updateFilename("dzveli.txt", "axali.txt", tempDir.toString());
    }
}
