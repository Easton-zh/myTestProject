package com.abc.zh.study.designpattern.factory.factorymethod;


import com.abc.zh.study.designpattern.factory.simplefactory.noodles.INoodles;
import com.abc.zh.study.designpattern.factory.simplefactory.noodles.LzNoodles;

public class LzINoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new LzNoodles();
    }
}
