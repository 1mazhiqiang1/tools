package com.djhu.imp.DesignMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:53
 * @VERSION:1.0.0
 */
class Subject {
    //观察者队伍
    private List<Observer> list = new ArrayList<Observer>();

    public void register(Observer observer) {
        list.add(observer);
    }
    public void remove(Observer observer) {
        list.remove(observer);
    }
    public void updateAllObserver() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}

