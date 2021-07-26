package com.abc.zh.study.designpattern.factory.factorymethod;

import com.abc.zh.study.designpattern.factory.simplefactory.noodles.INoodles;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class Test {
    public static void main(String[] args) {

        //1.创建一个兰州拉面工厂
        INoodlesFactory noodlesFactory = new LzINoodlesFactory();
        //2.由兰州拉面工厂生产拉面
        INoodles noodles = noodlesFactory.createNoodles();
        noodles.desc();
    }
}
