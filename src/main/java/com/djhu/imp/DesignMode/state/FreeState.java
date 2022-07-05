package com.djhu.imp.DesignMode.state;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:40
 * @VERSION:1.0.0
 */
//ConcreteState 具体类
class FreeState implements  State{
    public void handle() {
        System.out.println("房间空闲，无人住");
    }
}