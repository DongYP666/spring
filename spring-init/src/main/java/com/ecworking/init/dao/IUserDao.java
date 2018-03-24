package com.ecworking.init.dao;

import com.ecworking.init.entity.User;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/22
 */
public interface IUserDao {

    void insert(User user);

    void update(User user);

    List<User> findAll();

    User findById(long id);

    String findNameById(long id);
}
