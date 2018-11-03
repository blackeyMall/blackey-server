package com.blackey.demo.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.demo.domain.SysCaptchaEntity;
import com.blackey.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TODO 描述
 *
 * @author wangwei
 * @date 2018/11/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCaptchaMapperTest {

    @Autowired
    SysCaptchaMapper sysCaptchaMapper;

    @Autowired
    UserMapper userMapper;


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

        Page page = new Page(1, 10);
        User user2 = new User();
        user2.setName("1");
        List<User> users = userMapper.queryPage(page, user2);


        User user = userMapper.selectById(1);
        System.out.println(user.toString());


        List<SysCaptchaEntity> sysCaptchaEntities = sysCaptchaMapper.selectList(null);
        Assert.assertEquals(5, sysCaptchaEntities.size());
        sysCaptchaEntities.forEach(System.out::println);
    }
}