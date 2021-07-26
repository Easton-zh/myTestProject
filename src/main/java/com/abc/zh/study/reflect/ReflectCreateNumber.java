package com.abc.zh.study.reflect;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * 8、利用反射创建数值：
 */
public class ReflectCreateNumber {

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls,25);
        //往数组里添加内容
        Array.set(array,0,"golang");
        Array.set(array,1,"Java");
        Array.set(array,2,"pytho");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array,3));

    }
}
