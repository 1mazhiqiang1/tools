package com.djhu.imp.DesignMode.adapter;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:05
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
