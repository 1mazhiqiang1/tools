package com.djhu.imp.DesignMode.ChainOfFesponsibility;


public class Director extends Leader {
    public Director(String name) {
        super(name);
    }
    /**
     * 主任处理请求为3天以下的假期，超过三天交给主任的上级经理
     * @param request
     */
    public void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3){
            System.out.println("主任"+name+"处理了请求人："+request.getEmpName()+"的假条，请求天数："+request.getLeaveDays());
        }else{
            //假条超过3天，并且主任的上级不为null时，交给上级处理
            if (this.nextLeader != null){
                this.nextLeader.handlerRequest(request);
            }
        }
    }
}
