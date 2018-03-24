package com.ecworking.init.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/24
 */
public class MybatisUtils {

    /**
     * 通过Reader对象读取Mybatis映射文件
     * 通过SqlSessionFactoryBuilder对象创建SqlSessionFactory对象
     * 获取当前线程的SQLSession
     * 事务默认开启
     * 通过SQLSession读取映射文件中的操作编号，从而读取SQL语句
     * 提交事务
     * 关闭资源
     */

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    private static SqlSessionFactory sqlSessionFactory;


    static{
        try {
            //加载mybatis.xml配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //单例模式 禁止外界通过new方法创建
    private MybatisUtils(){}

    /**
     * 获取SqlSession
     */
    public static SqlSession getSqlSession(){
        //从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
        //如果SqlSession对象为空
        if(sqlSession == null){
            //在SqlSessionFactory非空的情况下，获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //将SqlSession对象与当前线程绑定在一起
            threadLocal.set(sqlSession);
        }
        //返回SqlSession对象
        return sqlSession;
    }

    /**
     * 关闭SqlSession与当前线程分开
     */
    public static void closeSqlSession(){
        //从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
        //如果SqlSession对象非空
        if(sqlSession != null){
            //关闭SqlSession对象
            sqlSession.close();
            //分开当前线程与SqlSession对象的关系，目的是让GC尽早回收
            threadLocal.remove();
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Connection conn = MybatisUtils.getSqlSession().getConnection();
        System.out.println(conn!=null?"连接成功":"连接失败");
    }
}
