package com.blackey.artisan.component.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


public interface FileUploadService {

    /**
     * 上传文件
     * @param request
     * @param file
     * @return
     */
    String uploadFile(HttpServletRequest request, MultipartFile file);

}
