package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:21
 * @VERSION:1.0.0
 */



/**
 * 负责和具体策略类交互
 * 具体的算法和直接客户调用分离了，使得算法可以独立于客户端独立变化。
 */

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double d) {
        System.out.println(strategy.getPrice(d));
    }
}
