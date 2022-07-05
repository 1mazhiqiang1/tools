package com.djhu.imp.DesignMode.decorator;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:21
 * @VERSION:1.0.0
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
