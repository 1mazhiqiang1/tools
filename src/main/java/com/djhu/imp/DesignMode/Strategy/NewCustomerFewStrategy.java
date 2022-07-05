package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:19
 * @VERSION:1.0.0
 */
class NewCustomerFewStrategy implements Strategy {
    public double getPrice(double standardPrice) {
        System.out.println("新单个用户，不打折，原价");
        return standardPrice;
    }
}
