package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:21
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Context ctx1 = new Context(new NewCustomerFewStrategy());
        ctx1.printPrice(1000);

        Context ctx2 = new Context(new NewCustomerManyStrategy());
        ctx2.printPrice(1000);

        Context ctx3 = new Context(new OldCustomerManyStrategy());
        ctx3.printPrice(1000);
    }

}
