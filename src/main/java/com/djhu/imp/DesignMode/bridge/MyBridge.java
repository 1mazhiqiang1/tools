package com.djhu.imp.DesignMode.bridge;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:46
 * @VERSION:1.0.0
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}