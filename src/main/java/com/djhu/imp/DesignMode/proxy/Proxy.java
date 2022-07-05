package com.djhu.imp.DesignMode.proxy;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:29
 * @VERSION:1.0.0
 */
public class Proxy implements Sourceable {

    private Source source;
    public Proxy(){
        super();
        this.source = new Source();
    }
    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }
    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}