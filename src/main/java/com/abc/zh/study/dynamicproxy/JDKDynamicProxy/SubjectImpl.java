package com.abc.zh.study.dynamicproxy.JDKDynamicProxy;

/**
 * 委托方，被代理类
 */
public class SubjectImpl implements Subject{

    @Override
    public void hello(String param) {
        System.out.println("hello " +param);
    }
}
