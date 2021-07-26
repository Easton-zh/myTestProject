package com.abc.zh.study.interfaces;

public interface PlayInterface extends GAnimal{

    public default void method() {
        System.out.println("测试接口方法是否可以被调用");
    }

    public abstract void play();
}
