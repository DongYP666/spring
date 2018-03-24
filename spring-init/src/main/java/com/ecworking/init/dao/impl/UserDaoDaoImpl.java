package com.ecworking.init.dao.impl;

import com.ecworking.init.dao.IUserDao;
import com.ecworking.init.entity.User;
import com.ecworking.init.handler.BeanHandler;
import com.ecworking.init.handler.BeanListHandler;
import com.ecworking.init.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class UserDaoDaoImpl implements IUserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        Object params[] = {};
        List<User> result = null;
        try {
            result = (List<User>)this.query(sql,params,new BeanListHandler(User.class));
        } catch (SQLException e) {
            new SQLException(e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        Object params[] = {id};
        User result = null;
        try {
            result = (User)this.query(sql,params,new BeanHandler(User.class));
        } catch (SQLException e) {
            new SQLException(e);
        }
        return result;
    }

    public Object query(String sql, Object params[], ResultSetHandler rsh) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();
            st = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                st.setObject(i+1, params[i]);
            }
            rs = st.executeQuery();
            /**
             * 对于查询返回的结果集处理使用到了策略模式，
             * 在设计query方法时，query方法事先是无法知道用户对返回的查询结果集如何进行处理的，即不知道结果集的处理策略，
             * 那么这个结果集的处理策略就让用户自己提供，query方法内部就调用用户提交的结果集处理策略进行处理
             * 为了能够让用户提供结果集的处理策略，需要对用户暴露出一个结果集处理接口ResultSetHandler
             * 用户只要实现了ResultSetHandler接口，那么query方法内部就知道用户要如何处理结果集了
             */
            return rsh.handler(rs);
        }finally{
            if(rs!=null){
                try{
                    //关闭存储查询结果的ResultSet对象
                    rs.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(st!=null){
                try{
                    //关闭负责执行SQL命令的Statement对象
                    st.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    //关闭Connection数据库连接对象
                    conn.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
