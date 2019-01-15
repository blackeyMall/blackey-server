package com.blackey.file;


import com.blackey.common.exception.BusinessException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService {


    private final static Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Resource
    private UrlPrefixConstants constants;


    @Override
    public String uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        if (!checkFileName(fileSuffix)){
            throw new BusinessException("文件名错误");
        }

        String fileName = generalFileName(constants.getServerName()) +
                fileSuffix;
        logger.info("上传文件请求发送，文件名: [{}]", fileName);
        try {
            uploadFile(file.getBytes(), constants.getRemoteAddress() + constants.getServerName() + "/", fileName);
        } catch (IOException e) {
            logger.error("图片文件流读取失败");
        }

        return constants.getServerDomain() +
                fileName;
    }

    @Override
    public List uploadFile(List<MultipartFile> files) {
        List picList = Lists.newArrayList();

        files.forEach(file -> {
            picList.add(uploadFile(file));
        });

        return picList;
    }


    /**
     * -----------------------------------
     */

    /**
     * 文件夹需要赋权，mac 下应用启动是非root
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public void uploadFile(byte[] file, String filePath, String fileName) {
        //创建文件夹
        File targetDire = new File(filePath);
        if (!targetDire.exists()) {
            targetDire.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filePath +
                fileName)) {
            out.write(file);
        } catch (IOException ex) {
            logger.error("图片文件流创建或写入失败");
        }

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
        int slat = secureRandom.nextInt(900) +
                100;

        long timestamp = System.currentTimeMillis();


        return tag +
                String.valueOf(slat) +
                String.valueOf(timestamp);
    }


    /**
     * 检查文件后缀名是否正确
     * @param fileSuffix
     * @throws Exception
     */
    public boolean checkFileName(String fileSuffix){
        List<String> checkList = Arrays.asList(".jpg",".png",".jpeg",".ppt",".doc",".xls",".pdf",".xlsx");
        return checkList.contains(fileSuffix);
    }


    public static void main(String[] args) throws Exception {
        FileUploadServiceImpl fileUploadServiceImpl = new FileUploadServiceImpl();
        System.out.println(fileUploadServiceImpl.generalFileName("A"));
        fileUploadServiceImpl.uploadFile("".getBytes(), "/opt/applications/qushe/filepath/", "1.jpg");

    }
}
