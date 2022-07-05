package com.djhu.imp.DesignMode.observer;


/**
 * @Author:mzq
 * @DATE:2019/8/1515:52
 * @VERSION:1.0.0
 */
//观察者
class ObserverA implements Observer {

    //与目标对象的 state 值一致
    private int myState;

    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }
    public int getMyState() {
        return myState;
    }
    public void setMyState(int myState) {
        this.myState = myState;
    }

}
