package com.blackey.tenant.rest;

import com.blackey.common.exception.FilterException;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.common.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误异常rest
 * @author wangwei : kaven
 *
 * @date: 2019/1/4 14:05
 **/
@RequestMapping("/sys/error")
@RestController
public class ErrorExceptionRest extends BaseRest {

    @GetMapping("/401")
    public Result handler401(HttpServletRequest request){

        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if(throwable instanceof FilterException){
            FilterException filterException = (FilterException)throwable;
            return new Result<>(filterException.getErrorCode(),filterException.getMessage());
        }
        return failure(ResultCodeEnum.UNAUTHORIZED);
    }

    @GetMapping("/500")
    public Result handler500(HttpServletRequest request){

        return failure(ResultCodeEnum.SYSTEM_ERROR);
    }
}
