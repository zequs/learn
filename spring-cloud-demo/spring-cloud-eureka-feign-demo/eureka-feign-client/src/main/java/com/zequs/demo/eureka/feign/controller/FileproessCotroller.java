package com.zequs.demo.eureka.feign.controller;

import com.zequs.demo.eureka.feign.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FileproessCotroller implements FileService{

    @Autowired
    private FileService fileService;

    @Override
    public ResponseEntity<byte[]> downloadFile(@RequestParam("fileType") String fileType) {
        ResponseEntity<byte[]> entity = fileService.downloadFile(fileType);
        System.out.println( entity.getStatusCode());
        return entity ;
    }

    @Override
    @ResponseBody
    public String uploadFile(@RequestPart("file") MultipartFile file, @RequestParam("fileType") String fileType) {
        return fileService.uploadFile(file, fileType);
    }
}
