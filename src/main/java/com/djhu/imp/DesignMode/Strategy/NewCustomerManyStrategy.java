package com.djhu.imp.DesignMode.Strategy;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:19
 * @VERSION:1.0.0
 */


class NewCustomerManyStrategy implements Strategy {
    public double getPrice(double standardPrice) {
        System.out.println("新批量用户，打九折");
        standardPrice = standardPrice * 0.9;
        return standardPrice;
    }
}