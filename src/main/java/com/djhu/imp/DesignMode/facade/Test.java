package com.djhu.imp.DesignMode.facade;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:35
 * @VERSION:1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
