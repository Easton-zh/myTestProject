package com.abc.zh.study.designpattern.singletion;

/**
 * 懒汉式单例模式: 三种方式实现
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton(){
    }

    /**
     * 单线程安全，多线程不安全！
     * 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
     * @return
     */
    public static LazySingleton getSingleton1() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    /**
     * 多线程安全，但是使用synchronized效率不高
     * @return
     */
    public static synchronized LazySingleton getSingleton2() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    //程序运行时创建一个静态只读的进程辅助对象
    private static Object syncRoot = new Object();


    /**
     * DCL双检查锁机制（DCL：double checked locking）
     * @return
     */
    public static LazySingleton getSingleton3() {
        // 第一次检查instance是否被实例化出来，如果没有进入if块
        if (singleton == null) {
            synchronized (syncRoot) {
                // 某个线程取得了类锁，实例化对象前第二次检查instance是否已经被实例化出来，如果没有，才最终实例出对象
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

}
