package com.abc.zh.study.reflect;

import com.abc.zh.pojo.Student;
import org.junit.Test;

/**
 * 获取类的Class对象三种方法：
 * （1）Object-->getClass
 * <p>
 * （2）任何数据类型（包括基本的数据类型）都有一个“静态”的class属性
 * <p>
 * （3）通过class类的静态方法：forName(String className)（最常用）
 */
public class GetClass {

    @Test
    public void getClassTest() throws ClassNotFoundException {
        Student student = new Student();
        Class<? extends Student> getClass = student.getClass();
        System.out.println("第一种方法获取类名："+getClass.getName());


        Class<Student> studentClass = Student.class;
        System.out.println("第二种方法获取类名："+studentClass.getName());
        System.out.println(getClass == studentClass);

        Class<?> forName = Class.forName("com.abc.zh.pojo.Student");
        System.out.println("第三种方法获取类名："+forName.getName());
        System.out.println(forName == studentClass);
    }
    /**
     * 总结：
     * 注意，在运行期间，一个类，只有一个Class对象产生，所以打印结果都是true；
     *
     * 三种方式中，常用第三种，第一种对象都有了还要反射干什么，第二种需要导入类包，依赖太强，不导包就抛编译错误。一般都使用第三种，一个字符串可以传入也可以写在配置文件中等多种方法。
     */
}
