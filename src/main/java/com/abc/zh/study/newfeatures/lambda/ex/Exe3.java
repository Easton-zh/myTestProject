package com.abc.zh.study.newfeatures.lambda.ex;

public class Exe3 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }
}
