package com.ecworking.init.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/22
 */
public class HelloProgram {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld helloWorld = service.getHelloWorld();

        helloWorld.sayHello();
    }
}
