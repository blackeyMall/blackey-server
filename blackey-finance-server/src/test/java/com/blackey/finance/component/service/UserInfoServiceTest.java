package com.blackey.finance.component.service;


import com.blackey.email.service.EmailService;
import com.blackey.finance.FinanceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 * @author : kaven
 *
 * @date: 2018/12/17 14:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinanceApplication.class)
@Slf4j
public class UserInfoServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    public void testEmail(){

        emailService.sendSimpleEmail("516372235@qq.com","主题www","内容wwww");
        System.out.println("-----");
    }
}
