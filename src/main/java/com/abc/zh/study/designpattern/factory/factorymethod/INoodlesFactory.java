package com.abc.zh.study.designpattern.factory.factorymethod;

import com.abc.zh.study.designpattern.factory.simplefactory.noodles.INoodles;

/**
 * 工厂方法模式
 */
public interface INoodlesFactory {

     INoodles createNoodles();
}