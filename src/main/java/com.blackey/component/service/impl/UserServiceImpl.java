package com.blackey.component.service.impl;

import com.blackey.component.model.User;
import com.blackey.component.repository.UserRepository;
import com.blackey.component.service.UserService;
import com.blackey.dto.form.UserForm;
import com.blackey.jpa.repo.BaseRepository;
import com.blackey.jpa.service.impl.BaseServiceImpl;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Resource
    private UserRepository userRepository;

    @Override
    protected BaseRepository<User> getRepo() {
        return userRepository;
    }


}
