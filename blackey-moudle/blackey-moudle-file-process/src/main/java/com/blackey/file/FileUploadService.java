package com.blackey.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FileUploadService {

    /**
     * 上传文件 上传的文件目录是filepath，最终访问的路径配置在domain中
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    /**
     * 上传文件 上传的文件目录是filepath，最终访问的路径配置在domain中
     *
     * @param files
     * @return
     */
    List uploadFile(List<MultipartFile> files);

}
