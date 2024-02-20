package com.melashvili.elasticsearch.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static String loadAsString(String path){
        try {
            final File recource = new ClassPathResource(path).getFile();
            return new String(Files.readAllBytes(recource.toPath()));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
