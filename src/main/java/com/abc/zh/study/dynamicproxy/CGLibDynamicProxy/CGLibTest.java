package com.abc.zh.study.dynamicproxy.CGLibDynamicProxy;

import com.abc.zh.study.dynamicproxy.ProxyFactory;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib 的原理是对指定目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对 final 修饰的类进行代理。
 *  注意：实现不实现接口都可以
 *
 */
public class CGLibTest {

    @Test
    public void test() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGSubject.class);
        enhancer.setCallback(new HelloInterceptor());
        CGSubject cGsubject = (CGSubject) enhancer.create();
        cGsubject.sayHello();
    }

    /**
     * 使用匿名内部类方式生成代理对象
     */
    @Test
    public void main() {
        //委托方
        CGSubject cgSubject = new CGSubject();

        CGSubject proxy = (CGSubject) Enhancer.create(cgSubject.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("CGlib动态代理：匿名内部类增强方法开始啦");
                Object invoke = method.invoke(cgSubject, objects);
                System.out.println("CGlib动态代理：匿名内部类增强方法结束啦");
                return invoke;
            }
        });
        proxy.sayHello();
    }

    /**
     * 使用匿名内部类方式生成代理对象
     */
    @Test
    public void testFactory() {
        //委托方
        CGSubject cgSubject = new CGSubject();
        CGSubject proxy = (CGSubject) ProxyFactory.getInstance().getCGlibProxy(cgSubject);
        proxy.sayHello();
    }
}
