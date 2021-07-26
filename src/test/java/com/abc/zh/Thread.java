package com.abc.zh;

import org.junit.Test;

public class Thread {

    @Test
    public void thread() {

        java.lang.Thread thread = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("run"+i);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            System.out.println("thread"+i);
        }

        thread.start();
    }
}

class myRun implements Runnable{


    @Override
    public void run() {
        System.out.println("线程......");
    }
}
