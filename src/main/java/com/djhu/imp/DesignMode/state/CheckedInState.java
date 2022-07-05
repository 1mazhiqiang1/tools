package com.djhu.imp.DesignMode.state;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:38
 * @VERSION:1.0.0
 */
class CheckedInState implements  State{
    public void handle() {
        System.out.println("房间已入住");
    }
}
