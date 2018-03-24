package com.ecworking.init.service;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;

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

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public User findOne(int id){
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
