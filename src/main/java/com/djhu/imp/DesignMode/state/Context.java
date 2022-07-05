package com.djhu.imp.DesignMode.state;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:39
 * @VERSION:1.0.0
 */
public class Context {

    private State state;
    public void setState(State state) {
        System.out.println("房间持有状态：");
        this.state = state;
        state.handle();
    }

}
