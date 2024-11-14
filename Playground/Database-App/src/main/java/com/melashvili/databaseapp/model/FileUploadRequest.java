package com.melashvili.databaseapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileUploadRequest {

    private String fileName;

    private byte[] fileContent;
}
