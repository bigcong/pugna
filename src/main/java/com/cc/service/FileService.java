package com.cc.service;

import java.util.List;

import com.cc.entity.File;

public interface FileService {
    List<File> listPageFile(File paramFile);

    Integer getFileCount();

    void insertFile(File paramFile);

    File getFileById(Integer paramInteger);

    File getFile(File paramFile);

    void updateFile(File paramFile);

    void deleteFile(File paramFile);

    void deleteFileByIds(String[] paramArrayOfString);
}