package com.zequs.demo.eureka.feign.api.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 导出
     * @param fileType
     * @return
     */
    @RequestMapping("/downloadFile")
    ResponseEntity<byte[]> downloadFile(@RequestParam("fileType") String fileType);

    /**
     * 导出
     * @param fileType
     * @return
     */
    @RequestMapping("/downTest")
    ResponseBean downTest(@RequestParam("fileType") String fileType);



    /**
     * 上传
     * @param file
     * @param fileType
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "fileType") String fileType);
}
