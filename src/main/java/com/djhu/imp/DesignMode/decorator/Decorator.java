package com.djhu.imp.DesignMode.decorator;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:21
 * @VERSION:1.0.0
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
