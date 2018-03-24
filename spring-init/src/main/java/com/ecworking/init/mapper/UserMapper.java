package com.ecworking.init.mapper;

import com.ecworking.init.entity.User;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/24
 */
public interface UserMapper {

    int insert(User user);

    int update(User user);

    List<User> findAll();

    User findById(int id);
}
