package com.djhu.imp.DesignMode.memento;

/**
 * @Author:mzq
 * @DATE:2019/8/1516:27
 * @VERSION:1.0.0
 */
public class CareTaker {

    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }
    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
