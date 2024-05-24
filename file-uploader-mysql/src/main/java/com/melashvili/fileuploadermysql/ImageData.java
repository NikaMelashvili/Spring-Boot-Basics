package com.melashvili.fileuploadermysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_uploader")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

    @Id
    @Column(name = "id")
    private Long ImageId;

    @Column(name = "file_name")
    private String FileName;

    @Column(name = "file_type")
    private String FileType;

    @Column(name = "file")
    private byte[] file;
}
