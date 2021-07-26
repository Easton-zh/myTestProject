package com.abc.zh.study.dynamicproxy.JDKDynamicProxy;

import com.abc.zh.study.dynamicproxy.ProxyFactory;
import org.junit.Test;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * JDK的动态代理，就是在程序运行的过程中，根据被代理的接口来动态生成代理类的class文件，并加载运行的过程。
 *  注意：委托方，必须实现接口
 */
public class JDKTest {

    @Test
    public void test() {
        //创建被代理实例
        Subject subject = new SubjectImpl();
        //创建代理实例
        InvocationHandler subjectProxy = new SubjectProxy(subject);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 1.第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 2.第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 3.第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        ClassLoader classLoader = subjectProxy.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler h = subjectProxy;
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(classLoader, interfaces, h);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用。
        proxyInstance.hello("world");
    }

    /**
     * 这个结果，实际上在Subject类中只会输出一条hello world，
     * 但是在被代理之后，实际调用的方法是SubjectProxy的invoke方法，
     * 这样可以在不修改业务类的情况下对业务类增加一些日志等其他操作，甚至可以直接修改有返回值方法的返回值。
     */


    /**
     * 匿名内部类实现JDK动态代理
     */
    @Test
    public void main() {
        Subject subject = new SubjectImpl();
        Subject o = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object object = null;
                System.out.println("JDK动态代理：匿名内部类实现代理开始啦");
                object = method.invoke(subject, objects);
                System.out.println("JDK动态代理：匿名内部类实现代理结束啦");
                return object;
            }
        });
        o.hello("代理对象执行方法!");
    }

    @Test
    public void test1() {
        Subject subject = new SubjectImpl();
        Subject obj = (Subject) ProxyFactory.getInstance().getJDKProxy(subject);
        obj.hello("代理工厂生成代理对象执行方法！");
    }
}
