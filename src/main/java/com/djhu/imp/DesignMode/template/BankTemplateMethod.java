package com.djhu.imp.DesignMode.template;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:26
 * @VERSION:1.0.0
 */
public abstract class  BankTemplateMethod {


    public void takeNumber(){
        System.out.println("取号排队");
    }
    public void evaluate(){
        System.out.println("反馈评分");
    }
    public abstract void transact(); //钩子方法：办理具体业务

    //模板方法
    public final void process(){
        this.takeNumber();
        this.transact();
    }
}
