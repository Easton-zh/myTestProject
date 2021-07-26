package com.abc.zh.study.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 创建实例：通过反射来生成对象主要有两种方法
 */
public class CreateNewInstance {

    /**
     * （1）使用Class对象的newInstance()方法来创建Class对象对应类的实例。
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {
        Class<String> stringClass = String.class;
        String s = stringClass.newInstance();
        System.out.println(s.length());
    }

    /**
     * （2）先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建对象，
     *     这种方法可以用指定的构造器构造类的实例。
     */
    @Test
    public void constructor() throws Exception {
        //获取String的Class对象
        Class<?> aClass = String.class;
        //通过Class对象获取指定的Constructor构造器对象
        Constructor constructor = aClass.getConstructor(String.class);
        //根据构造器创建实例：
        Object o = constructor.newInstance("newInstance");
        System.out.println(o.toString());

    }

}
