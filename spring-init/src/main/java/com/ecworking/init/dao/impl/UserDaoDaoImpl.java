package com.ecworking.init.dao.impl;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/22
 */
public class UserDaoDaoImpl implements IUserDao {

    //获取和当前线程绑定的Seesion
    private Session getSession() {
        //获取加载配置管理类
        Configuration configuration = new Configuration();

        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();

        return factory.openSession();
    }

    @Override
    public void save(User user) {
        //获取加载配置管理类
        Configuration configuration = new Configuration();
        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();
        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();
        //得到Session对象
        Session session = factory.openSession();
        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();
        //开启事务
        transaction.begin();
        //把对象添加到数据库中
        session.save(user);
        //提交事务
        transaction.commit();
        //关闭Session
        session.close();
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
        Query query=getSession().createQuery(hql).setParameter(0, id);
        User result = (User)query.uniqueResult();
        return result;
    }

    @Override
    public String findNameById(long id) {
        String hql = "select username from User where id=?";
        Query query=getSession().createQuery(hql).setParameter(0, id);
        String result = (String)query.uniqueResult();
        return result;
    }
}
