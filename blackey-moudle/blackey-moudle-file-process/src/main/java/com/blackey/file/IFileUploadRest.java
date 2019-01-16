package com.blackey.file;


import com.blackey.common.exception.BusinessException;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
public class IFileUploadRest extends BaseRest {


    @Resource
    private FileUploadService fileUploadService;


    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            logger.error("没有可用的文件");
            return success();
        }

        try {
            String fileName = fileUploadService.uploadFile(file);
            return success(fileName);
        } catch (BusinessException e)
        {
            return failure();
        }
    }

    @PostMapping("/multi/upload")
    public Result uploadMultiFiles(@RequestParam("files") List<MultipartFile> files){

        if (files.size() < 1){
            logger.error("没有可用的文件");
            return success();
        }

        return success(fileUploadService.uploadFile(files));

    }

}
