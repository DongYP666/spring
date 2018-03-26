package com.ecworking.init.controller;

import com.ecworking.init.entity.User;
import com.ecworking.init.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/23
 */
public class UserController {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService service = context.getBean(UserService.class);

        List<User> list = service.findAll();

        list.stream().forEach(user -> {
            System.out.println("id=" + user.getId() + ",username=" + user.getUsername());
        });
    }
}
