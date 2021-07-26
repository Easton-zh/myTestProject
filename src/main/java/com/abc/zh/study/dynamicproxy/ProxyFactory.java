package com.abc.zh.study.dynamicproxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * 代理工厂生成委托对象
 */
public class ProxyFactory {

    private static ProxyFactory proxyFactory = new ProxyFactory();

    private ProxyFactory(){
    }

    public static ProxyFactory getInstance() {
        return proxyFactory;
    }

    /**
     * 生成JDK动态代理对象
     * @param obj 委托对象
     * @return 代理对象
     */
    public Object getJDKProxy(Object obj) {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object object = null;
                System.out.println("匿名内部类实现代理开始啦");
                method.invoke(obj, objects);
                System.out.println("匿名内部类实现代理结束啦");
                return object;
            }
        });
    }


    public Object getCGlibProxy(Object obj) {
        return Enhancer.create(obj.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("CGlib动态代理：匿名内部类增强方法开始啦");
                Object invoke = method.invoke(obj, objects);
                System.out.println("CGlib动态代理：匿名内部类增强方法结束啦");
                return invoke;
            }
        });
    }
}
