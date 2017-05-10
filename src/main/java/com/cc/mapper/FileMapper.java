package com.cc.mapper;

import java.util.List;

import com.cc.entity.File;

public interface FileMapper {
    List<File> listPageFile(File paramFile);

    Integer getFileCount();

    void insertFile(File paramFile);

    File getFileById(Integer paramInteger);

    File getFile(File paramFile);

    void updateFile(File paramFile);

    void deleteFile(File paramFile);

    void deleteFileByIds(String[] paramArrayOfString);
}