package com.abc.zh.study.designpattern.factory.factorymethod;


import com.abc.zh.study.designpattern.factory.simplefactory.noodles.INoodles;
import com.abc.zh.study.designpattern.factory.simplefactory.noodles.PaoNoodles;

public class PaoINoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new PaoNoodles();
    }
}
