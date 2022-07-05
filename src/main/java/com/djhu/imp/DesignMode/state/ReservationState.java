package com.djhu.imp.DesignMode.state;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:37
 * @VERSION:1.0.0
 */
//ConcreteState 具体类
class ReservationState implements  State{
    public void handle() {
        System.out.println("预定状态，无人住");
    }
}

