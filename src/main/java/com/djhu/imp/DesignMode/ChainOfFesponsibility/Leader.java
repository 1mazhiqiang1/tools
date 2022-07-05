package com.djhu.imp.DesignMode.ChainOfFesponsibility;

import com.djhu.imp.DesignMode.ChainOfFesponsibility.LeaveRequest;

/**
 * 抽象类
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;//责任链上的下一个对象

    public Leader(String name) {
        this.name = name;
    }

    // 设置责任链上的下一个对象
    public void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }

    //处理请求的核心的业务方法
    public abstract  void handlerRequest(LeaveRequest request);
}
