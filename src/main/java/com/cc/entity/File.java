package com.cc.entity;

import java.util.Date;

public class File {
    private int file_id;

    private String file_name;

    private String file_type;

    private String file_extension;

    private Date upload_time;

    private int upload_id;

    private String file_path;

    private String title;

    private String description;

    private int link_id;

    private Date save_time;

    private int is_delete;

    private String upload_ip;

    private int is_enable;

    private long file_size;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public int getFile_id() {
        return this.file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return this.file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_extension() {
        return this.file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public Date getUpload_time() {
        return this.upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public int getUpload_id() {
        return this.upload_id;
    }

    public void setUpload_id(int upload_id) {
        this.upload_id = upload_id;
    }

    public String getFile_path() {
        return this.file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLink_id() {
        return this.link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public Date getSave_time() {
        return this.save_time;
    }

    public void setSave_time(Date save_time) {
        this.save_time = save_time;
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getUpload_ip() {
        return this.upload_ip;
    }

    public void setUpload_ip(String upload_ip) {
        this.upload_ip = upload_ip;
    }

    public int getIs_enable() {
        return this.is_enable;
    }

    public void setIs_enable(int is_enable) {
        this.is_enable = is_enable;
    }
}