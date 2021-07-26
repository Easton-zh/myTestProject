package com.abc.zh.study.designpattern.proxy;

public class RealServer implements Network{
    @Override
    public void browse() {
        System.out.println("真是上网服务器");
    }
}
