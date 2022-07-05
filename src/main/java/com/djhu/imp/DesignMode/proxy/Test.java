package com.djhu.imp.DesignMode.proxy;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:30
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
