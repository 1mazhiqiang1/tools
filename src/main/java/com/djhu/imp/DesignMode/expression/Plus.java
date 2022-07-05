package com.djhu.imp.DesignMode.expression;

/**
 * @Author:mzq
 * @DATE:2019/8/1610:04
 * @VERSION:1.0.0
 */

public class Plus implements Expression {


    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}

