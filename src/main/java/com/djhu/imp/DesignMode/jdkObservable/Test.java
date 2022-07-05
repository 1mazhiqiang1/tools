package com.djhu.imp.DesignMode.jdkObservable;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:56
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args){
      ObserverA a1 = new ObserverA();
      ObserverA a2 = new ObserverA();
      ObserverA a3 = new ObserverA();

      ConcreteSubject sub  = new ConcreteSubject();
        sub.addObserver(a1);
        sub.addObserver(a2);
        sub.addObserver(a3);
        sub.setState(3000);

        System.out.println(a1.getMyState());
        System.out.println(a2.getMyState());
        System.out.println(a3.getMyState());
        System.out.println();
    }

}
