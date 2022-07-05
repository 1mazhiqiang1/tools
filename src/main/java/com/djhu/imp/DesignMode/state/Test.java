package com.djhu.imp.DesignMode.state;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:39
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args){
        Context ctx =new Context();
        ctx.setState(new FreeState());
        System.out.println();
        ctx.setState(new ReservationState());
    }

}
