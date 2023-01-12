package com.jetbrains.yash.Photoclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;

import java.security.PrivateKey;

public class Photo {

    private String id;
    @NotEmpty
    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public Photo() {
    }


    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
