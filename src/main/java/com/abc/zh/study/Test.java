package com.abc.zh.study;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("atguigushk.txt");
        int b; b = in.read();
        while (b != -1) {
            System.out.print((char) b);
            b = in.read();
        }
        in.close();
    }

    @org.junit.Test
    public void test() {
        System.out.println("测试注解");
    }
}
