package com.blackey.rest;

import com.blackey.component.model.User;
import com.blackey.component.service.UserService;
import com.blackey.dto.bo.UserBo;
import com.blackey.dto.form.UserForm;
import com.blackey.dto.search.UserSearch;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public void save(UserForm form) throws Exception {
        userService.saveForm(form);
    }

    @GetMapping("/{id}")
    public User detail(@PathVariable String id){
        return userService.detail(id);
    }

    @PostMapping("/delete")
    public void delete(String[] ids){
        userService.fakeDeleteById(ids);
    }

    @GetMapping("/list")
    public List<User> list(@RequestBody UserSearch search){
        return userService.list(search);
    }

    @GetMapping("/list")
    public Page<User> page(@RequestBody UserSearch search){
        return userService.pageList(search);
    }
}
