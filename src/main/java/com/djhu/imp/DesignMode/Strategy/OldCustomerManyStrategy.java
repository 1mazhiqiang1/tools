package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:20
 * @VERSION:1.0.0
 */

class OldCustomerManyStrategy implements Strategy {
    public double getPrice(double standardPrice) {
        System.out.println("批量老用户，打八折");
        standardPrice = standardPrice * 0.8;
        return standardPrice;
    }
}

