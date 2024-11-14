package com.melashvili.fileuploadermysql.atomic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewFileName {

    private String oldFilename;

    private String newFilename;

    private String directoryPath;
}
