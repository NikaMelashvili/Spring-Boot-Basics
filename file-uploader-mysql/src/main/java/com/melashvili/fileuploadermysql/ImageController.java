package com.melashvili.fileuploadermysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image image = imageService.saveImage(file);
            return new ResponseEntity<>(image, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Image> optionalImage = imageService.getImage(id);
        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + image.getName() + "\"")
                    .body(image.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
