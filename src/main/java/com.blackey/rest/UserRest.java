package com.blackey.rest;

import com.blackey.component.service.UserService;
import com.blackey.dto.form.UserForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@RestController
@RequestMapping("/server/user")
public class UserRest {

    @Resource
    private UserService userService;


    @PostMapping("/save")
    public void save(UserForm form){
        userService.save(form);
    }

}
