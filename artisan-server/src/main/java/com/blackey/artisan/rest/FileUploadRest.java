package com.blackey.artisan.rest;


import com.blackey.artisan.component.service.FileUploadService;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/finance/file")
@RestController
public class FileUploadRest extends BaseRest {


    @Resource
    FileUploadService fileUploadService;

    @Resource
    HttpServletRequest request;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        try {
            String fileName = fileUploadService.uploadFile(request,file);
            return success(fileName);
        } catch (Exception e)
        {
            return failure();
        }
    }

}
