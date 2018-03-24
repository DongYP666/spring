package com.ecworking.init.dao.impl;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/22
 */
@Transactional
public class UserDaoDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取与当前线程绑定的session
     * @return
     */
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(User user) {
        getSession().save(user);
    }

    public void update(User user){
        String hql = "update User set username=?,password=?,email=?,birthday=? where id=?";
        Query query = getSession().createQuery(hql)
                .setString(0,user.getUsername())
                .setString(1,user.getPassword())
                .setString(2,user.getEmail())
                .setDate(3,user.getBirthday())
                .setLong(4,user.getId());
        query.executeUpdate();
    }

    @Override
    public List<User> findAll() {
        String hql = "from User";
        Query query = getSession().createQuery(hql);
        List<User> result = query.list();
        return result;
    }

    @Override
    public User findById(long id) {
        String hql = "from User where id=?";
        Query query=getSession().createQuery(hql).setLong(0, id);
        User result = (User)query.uniqueResult();
        return result;
    }

    @Override
    public String findNameById(long id) {
        String hql = "select username from User where id=?";
        Query query=getSession().createQuery(hql).setLong(0, id);
        String result = (String)query.uniqueResult();
        return result;
    }
}
