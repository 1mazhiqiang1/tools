package com.djhu.imp.DesignMode.jdkObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:17
 * @VERSION:1.0.0
 */
//观察者
class ObserverA implements Observer {
    //与目标对象的 state 值一致
    private int myState;
    public int getMyState() {
        return myState;
    }
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }
}
