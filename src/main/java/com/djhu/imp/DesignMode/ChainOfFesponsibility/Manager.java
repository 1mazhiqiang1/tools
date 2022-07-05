package com.djhu.imp.DesignMode.ChainOfFesponsibility;


public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    /**
     * 经理处理请求为大于3天小于10天的假期，超过10天交给上级总经理处理
     * @param request
     */
    public void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 10){
            System.out.println("经理："+name+"处理了请求人："+request.getEmpName()+"的假条，请求天数："+request.getLeaveDays());
        }else{
            //假条超过10天，并且经理的上级不为null时，交给上级处理
            if (this.nextLeader != null){
                this.nextLeader.handlerRequest(request);
            }
        }
    }
}
