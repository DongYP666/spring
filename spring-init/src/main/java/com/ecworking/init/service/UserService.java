package com.ecworking.init.service;

import com.ecworking.init.entity.User;
import com.ecworking.init.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/23
 */
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findOne(int id){
        return userMapper.findById(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
