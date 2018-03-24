package com.ecworking.init.service;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;
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
    private IUserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(long id){
        return userDao.findById(id);
    }

    public String findName(long id){
        return userDao.findNameById(id);
    }
}
