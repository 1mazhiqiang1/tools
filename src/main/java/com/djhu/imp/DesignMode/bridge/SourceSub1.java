package com.djhu.imp.DesignMode.bridge;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:45
 * @VERSION:1.0.0
 */
public class SourceSub1 implements Sourceable {

    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
