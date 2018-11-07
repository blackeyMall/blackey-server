package com.blackey.artisan.component.service.impl;


import com.blackey.artisan.component.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.security.SecureRandom;

/**
 *
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {


    private final static Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Value("${file.upload.path}")
    private String fileStorePath;

    @Value("${http.domain}")
    private String domain;


    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileName = generalFileName("A") + originalFileName.substring(originalFileName.indexOf("."), originalFileName.length());

        try {
            this.uploadFile(file.getBytes(), fileStorePath, fileName);
        } catch (Exception e) {
            logger.error("upload file error !");
        }
        return domain + fileStorePath + fileName;
    }

    /**
     * 文件夹需要赋权，mac 下应用启动是非root
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 图片名称随机生成器
     * <p>
     * 规则：图片标识 + 3位随机码 + 时间戳
     *
     * @param tag 图片标识由应用传过来
     * @return
     */
    public String generalFileName(String tag) {
        SecureRandom secureRandom = new SecureRandom();
        int slat = secureRandom.nextInt(900) + 100;

        long timestamp = System.currentTimeMillis();

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(tag)
                .append(String.valueOf(slat))
                .append(String.valueOf(timestamp));


        return sBuilder.toString();
    }


    public static void main(String[] args) throws Exception {
        FileUploadServiceImpl fileUploadServiceImpl = new FileUploadServiceImpl();
        System.out.println(fileUploadServiceImpl.generalFileName("A"));
        fileUploadServiceImpl.uploadFile("".getBytes(), "/opt/applications/qushe/filepath/", "1.jpg");

    }
}
