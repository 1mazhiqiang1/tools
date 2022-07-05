package com.djhu.imp.DesignMode.template;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:27
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args){
        //采用匿名内部类实现模板方法调用
        BankTemplateMethod btm = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要取款！");
            }
        };
        btm.process();
        System.out.println();
        //采用匿名内部类实现模板方法调用
        BankTemplateMethod btmbtm = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要该业务！");
            }
        };
        btmbtm.process();
    }

}
