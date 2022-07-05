package com.djhu.imp.DesignMode.adapter;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:05
 * @VERSION:1.0.0
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
