package cn.mn.file_upload.vo;

import lombok.Data;

@Data
public class FileLocation{
    private String fileName;
    private String path;
    private String host;
    private String url;

    public FileLocation() {
    }

    public FileLocation(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }
}