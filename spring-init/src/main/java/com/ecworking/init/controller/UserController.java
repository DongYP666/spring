package com.ecworking.init.controller;

import com.ecworking.init.service.UserService;
import com.ecworking.init.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
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

//        User user = new User();
//        user.setUsername("aaaaaaaaa？？？？");
//        user.setPassword("bbbbbbbbb？？？？");
//        user.setEmail("727247012@qq.com");
//        user.setBirthday(new Date());
//        service.save(user);

//        List<User> list = service.findAll();
//        list.stream().forEach(user -> {
//            System.out.println("id=" + user.getId() + ",username=" + user.getUsername());
//        });

//        User user = service.findOne(1);
//        System.out.println("id=" + user.getId() + ",username=" + user.getUsername());

        System.out.println(service.findName(1));
    }
}
