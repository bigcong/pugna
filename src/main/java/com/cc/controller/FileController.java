package com.cc.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cc.entity.File;
import com.cc.service.FileService;

@RestController
@RequestMapping({"/file"})
public class FileController {

    @Autowired
    private FileService fileService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
                true));
    }

    @RequestMapping
    public List<File> list(File file, ModelMap modelMap) {
        List<File> fileList = this.fileService.listPageFile(file);
        return fileList;
    }

    @RequestMapping(value = {"/save"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public File save(File file, MultipartFile img, HttpServletRequest request) {
        file.setDescription("");
        file.setFile_extension(img.getName());
        file.setFile_name(img.getOriginalFilename());
        file.setFile_type(img.getContentType());
        file.setFile_size(img.getSize());
        file.setIs_delete(0);
        file.setIs_enable(1);
        file.setSave_time(new Date());
        file.setTitle("");
        file.setUpload_time(new Date());
        file.setUpload_ip(getRemortIP(request));
        java.io.File targetFile = null;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String dateTime = dateFormat.format(date);
        if (System.getProperties().getProperty("os.name").toUpperCase()
                .indexOf("WINDOWS") != -1) {
            targetFile = new java.io.File("e:/upload/" + dateTime);
            if ((!targetFile.exists()) && (!targetFile.isDirectory())) {
                targetFile.mkdir();
            }

            targetFile = new java.io.File("e:/upload/" + dateTime + "/"
                    + System.currentTimeMillis() + img.getOriginalFilename());
        } else {
            targetFile = new java.io.File("/upload/" + dateTime);
            if (!targetFile.exists()) {
                targetFile.mkdir();
            }
            targetFile = new java.io.File("/upload/" + dateTime + "/"
                    + System.currentTimeMillis() + img.getOriginalFilename());
        }

        try {
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            img.transferTo(targetFile);
            file.setFile_path(targetFile.getAbsolutePath());
            this.fileService.insertFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    @RequestMapping({"/delete/{file_id}"})
    public List<File> delete(@PathVariable int file_id) {
        File file = new File();
        file.setFile_id(file_id);
        this.fileService.deleteFile(file);
        return this.fileService.listPageFile(new File());
    }

    @RequestMapping({"/view/{file_id}"})
    public File view(@PathVariable int file_id, HttpServletResponse response) {
        File file = this.fileService.getFileById(Integer.valueOf(file_id));
        try {
            FileInputStream f = new FileInputStream(file.getFile_path());
            byte[] data = new byte[f.available()];
            f.read(data);
            OutputStream toClient = response.getOutputStream();

            toClient.write(data);
            toClient.flush();
            toClient.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}