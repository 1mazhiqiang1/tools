package com.djhu.imp.DesignMode.ChainOfFesponsibility;

/**
 * @Author:mzq
 * @DATE:2019/8/1515:13
 * @VERSION:1.0.0
 */
public class Test {

    public static void main(String[] args){
        //创建请假人
        LeaveRequest request = new LeaveRequest("小明",100,"");
        Leader l1 = new Director("小黑"); //创建主任
        Leader l2 = new Manager("小白");  //创建经理
        Leader l3 = new GeneralManager("老大"); //创建总经理

        //设置上下级关系
        l1.setNextLeader(l2);
        l2.setNextLeader(l3);
        //当改变请假天数时，审批人也会随之改变
        l1.handlerRequest(request);
    }
}
