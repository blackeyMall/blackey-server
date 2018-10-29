package com.blackey.component.service.impl;

import com.blackey.component.model.User;
import com.blackey.component.repository.UserRepository;
import com.blackey.component.service.UserService;
import com.blackey.dto.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户service impl
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;


    @Override
    public void save(UserForm form) {
        User user = new User();
        BeanUtils.copyProperties(form,user);
        userRepository.save(user);
    }
}
