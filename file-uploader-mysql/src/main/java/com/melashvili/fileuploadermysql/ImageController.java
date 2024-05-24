package com.melashvili.fileuploadermysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("images")
                                              MultipartFile multipartFile) throws IOException {
        String filename = imageService.uploadImage(multipartFile);
        return ResponseEntity.ok().body(filename);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<String> downloadImage(@PathVariable
                                                String fileName) throws IOException {
        byte[] image = imageService.downloadImage(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png"))
                .body(image.toString());
    }
}
