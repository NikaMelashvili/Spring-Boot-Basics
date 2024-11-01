package com.melashvili.fileuploadermysql.uploader;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "photo_upload")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_name")
    private String name;

    @Lob
    @Column(name = "image_binary")
    private byte[] data;

}