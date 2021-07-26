package com.abc.zh.study.designpattern.singletion;

/**
 * 单例模式：
 *      1.饿汉式单例模式
 *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class HungrySingleton {

    private HungrySingleton() {
    }

    private static HungrySingleton singleton = new HungrySingleton();

    /**
     * 及时加载/饿汉式单例模式
     * @return
     */
    public static HungrySingleton getSingleton() {
        return singleton;
    }


}
