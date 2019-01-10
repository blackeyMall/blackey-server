package com.blackey.file;


import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Slf4j
public class FileUploadRest extends BaseRest {


    @Resource
    FileUploadService fileUploadService;

    @Resource
    HttpServletRequest request;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            logger.error("没有可用的文件");
            return success();
        }


        try {
            String fileName = fileUploadService.uploadFile(request,file);
            return success(fileName);
        } catch (Exception e)
        {
            return failure();
        }
    }

}
