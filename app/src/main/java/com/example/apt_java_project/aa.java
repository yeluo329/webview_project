package com.example.apt_java_project;


import com.example.apt_java_project.daili.Ljz;
import com.example.apt_java_project.daili.Message;
import com.example.apt_java_project.daili.Wash;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class aa {

    public void test() {
        Ljz ljz = new Ljz();
        Object obj = Proxy.newProxyInstance(aa.class.getClassLoader(), new Class[]{Wash.class, Message.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(ljz, args);

            }
        });

        Message message = (Message) obj;
        message.message("123");

        Wash wash = (Wash) obj;
        wash.wash();



    }
}


