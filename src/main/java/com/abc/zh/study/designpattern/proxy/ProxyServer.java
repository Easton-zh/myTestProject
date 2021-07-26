package com.abc.zh.study.designpattern.proxy;

/**
 * 静态代理
 */
class ProxyServer implements Network{

    private Network network;

    public ProxyServer(Network network) {
        this.network = network; }


    public void check() {
        System.out.println("检查网络连接等操作");
    }

    public void browse() {
        check();
        network.browse();
    }
}
