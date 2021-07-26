package com.abc.zh;

public class Demo {
}

interface A {
    int x = 0;

    public default void method() {
        System.out.println("接口中默认方法！");
    }
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
        //System.out.println(x);   todo 此处有问题，A接口中变量是不可变静态变量，B类中普通成员变量，需new对象调用
    }
    public static void main(String[] args) {
        new C().pX();

        A a = new C();
        a.method();
    }

}
