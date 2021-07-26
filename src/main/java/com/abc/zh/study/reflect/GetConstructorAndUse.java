package com.abc.zh.study.reflect;

import com.abc.zh.pojo.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 4、通过反射获取构造方法并使用：
 *
 * （1）批量获取的方法：
 * public Constructor[] getConstructors()：所有"公有的"构造方法
 * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
 *
 * （2）单个获取的方法，并调用：
 * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 * （3） 调用构造方法：
 *
 * Constructor-->newInstance(Object... initargs)
 *
 * newInstance是 Constructor类的方法（管理构造函数的类）
 *
 * api的解释为：newInstance(Object... initargs) ，使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
 *
 * 它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象，并为之调用。
 * ————————————————
 * 原文链接：https://blog.csdn.net/a745233700/article/details/82893076
 */
public class GetConstructorAndUse {

    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> aClass = (Class<Student>) Class.forName("com.abc.zh.pojo.Student");

        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = aClass.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = aClass.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = aClass.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("con = " + con);

        //调用构造方法
        Object obj = con.newInstance();
        //	System.out.println("obj = " + obj);
        //	Student stu = (Student)obj;

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = aClass.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance('男');

    }

}
