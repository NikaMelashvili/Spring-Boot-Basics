package com.melashvili.fileuploadermysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        imageRepository.save(ImageData.builder()
                .FileName(file.getName())
                .FileType(file.getContentType())
                .file(ImageCompressor.compressImage(file.getBytes())).build());
        if (file != null && !file.isEmpty()) {
            return "Image uploaded successfully";
        }
        return "Image upload failed";
    }

    public byte[] downloadImage(String imageName) throws IOException {
        Optional<ImageData> imageData = imageRepository.findByFileName(imageName);
        byte[] image = ImageCompressor.decompressImage(imageData.get().getFile());
        return image;
    }
}
