package com.abc.zh.study.interfaces;


/**
 * 测试接口可以多实现
 */
public class Student implements PlayInterface, StudyInterface{

    @Override
    public void play() {
        System.out.println("玩");
    }

    @Override
    public void study() {
        System.out.println("学");
    }

    @Override
    public void isAnimal() {
        System.out.println("是高级动物！");
    }

    public static void main(String[] args) {
        PlayInterface playInterface = new Student();

        playInterface.method();
    }


}
