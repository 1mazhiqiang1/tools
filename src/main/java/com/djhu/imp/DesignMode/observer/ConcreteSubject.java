package com.djhu.imp.DesignMode.observer;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:52
 * @VERSION:1.0.0
 */
//目标对象
class ConcreteSubject extends Subject {
    private int state;
    public int getState() {
        return state;
    }
    //当目标对象的状态发生变化，便通知其下所有观察者
    public void setState(int state) {
        this.state = state;
        super.updateAllObserver();
    }
}
