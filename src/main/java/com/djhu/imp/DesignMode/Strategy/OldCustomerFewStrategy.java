package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:20
 * @VERSION:1.0.0
 */

class OldCustomerFewStrategy implements Strategy {
    public double getPrice(double standardPrice) {
        System.out.println("老用户，打八五折");
        standardPrice = standardPrice * 0.85;
        return standardPrice;
    }
}
