package com.cc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.entity.File;
import com.cc.mapper.FileMapper;
import com.cc.service.FileService;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    public List<File> listPageFile(File file) {
        return this.fileMapper.listPageFile(file);
    }

    public Integer getFileCount() {
        return this.fileMapper.getFileCount();
    }

    public void insert(File file) {
        this.fileMapper.insertFile(file);
    }

    public File getFileById(Integer id) {
        return this.fileMapper.getFileById(id);
    }

    public File getFile(File file) {
        return this.fileMapper.getFile(file);
    }

    public void updateFile(File file) {
        this.fileMapper.updateFile(file);
    }

    public void deleteFile(File file) {
        file = this.fileMapper.getFileById(Integer.valueOf(file.getFile_id()));

        java.io.File file2 = new java.io.File(file.getFile_path());
        if (file2.exists()) {
            file2.delete();
        }

        this.fileMapper.deleteFile(file);
    }

    public void deleteFileByIds(String[] ids) {
        this.fileMapper.deleteFileByIds(ids);
    }

    public void insertFile(File file) {
        this.fileMapper.insertFile(file);
    }
}