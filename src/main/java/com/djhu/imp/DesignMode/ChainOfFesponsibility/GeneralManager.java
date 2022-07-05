package com.djhu.imp.DesignMode.ChainOfFesponsibility;

public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    /**
     * 总经理处超过10天的假条
     * @param request
     */
    public void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() > 10){
            System.out.println("总经理："+name+"处理了请求人："+request.getEmpName()+"的假条，请求天数："+request.getLeaveDays());
        }
    }
}
