package com.djhu.imp.DesignMode.decorator;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:23
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
