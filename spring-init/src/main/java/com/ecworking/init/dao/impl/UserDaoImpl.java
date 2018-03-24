package com.ecworking.init.dao.impl;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;
import com.ecworking.init.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/24
 */
public class UserDaoImpl implements IUserDao{
    @Override
    public void insert(User user) {
        //得到连接对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("com.ecworking.init.mapper.UserMapper.insert", user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            sqlSession.update("com.ecworking.init.mapper.UserMapper.update", user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        return sqlSession.selectList("com.ecworking.init.mapper.UserMapper.findAll");
    }

    @Override
    public User findById(long id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        return sqlSession.selectOne("com.ecworking.init.mapper.UserMapper.findById",id);
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();

//        User user = new User();
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEmail("8888@163.com");
//        user.setBirthday(new Date());
//        userDao.insert(user);
//
//        user.setId(1);
//        userDao.update(user);

//        List<User> list = userDao.findAll();
//        list.stream().forEach(user -> {
//            System.out.println("id=" + user.getId() + ",username=" + user.getUsername());
//        });

        User user = userDao.findById(1);
        System.out.println("id=" + user.getId() + ",username=" + user.getUsername());
    }
}
