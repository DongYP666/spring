package com.ecworking.init.handler;

import java.sql.ResultSet;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/7
 */
public interface ResultSetHandler {
    /**
     * 结果集处理方法
     * @param rs
     * @return
     */
    public Object handler(ResultSet rs);
}
