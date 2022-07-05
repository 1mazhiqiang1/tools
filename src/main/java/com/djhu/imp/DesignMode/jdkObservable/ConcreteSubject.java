package com.djhu.imp.DesignMode.jdkObservable;

import java.util.Observable;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:17
 * @VERSION:1.0.0
 */

//目标对象
class ConcreteSubject extends Observable {
    private int state;
    public int getState() {
        return state;
    }
    public void setState(int state){
        this.state = state;
        setChanged();//表示目标对象已经做出更改
        notifyObservers(state); //通知旗下所有观察者
    }
}

