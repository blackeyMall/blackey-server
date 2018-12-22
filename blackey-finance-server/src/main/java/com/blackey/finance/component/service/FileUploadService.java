package com.blackey.finance.component.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


public interface FileUploadService {

    /**
     * 上传文件 上传的文件目录是filepath，最终访问的路径配置在domain中
     *
     * @param request
     * @param file
     * @return
     */
    String uploadFile(HttpServletRequest request, MultipartFile file);

}
