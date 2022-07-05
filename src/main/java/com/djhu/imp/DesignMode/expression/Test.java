package com.djhu.imp.DesignMode.expression;

/**
 * @Author:mzq
 * @DATE:2019/8/1610:05
 * @VERSION:1.0.0
 */
public class Test {



    public static void main(String[] args) {


        // 计算9+2-8的值
        int result = new Minus().interpret((new Context(new Plus()
                .interpret(new Context(9, 2)), 8)));
        System.out.println(result);
    }

}
