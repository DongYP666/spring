package dao;

import entity.User;

import java.sql.SQLException;
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
    List<User> findAll();

    User findById(int id);
}
