package com.abc.zh.study.dynamicproxy.CGLibDynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class HelloInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin time -----> "+ new Date());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("end time -----> "+ new Date());
        return o1;
    }
}
