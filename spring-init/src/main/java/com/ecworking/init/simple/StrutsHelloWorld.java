package com.ecworking.init.simple;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/22
 */
public class StrutsHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Struts say Hello!");
    }
}
