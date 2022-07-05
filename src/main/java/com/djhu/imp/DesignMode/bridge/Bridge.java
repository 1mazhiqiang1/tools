package com.djhu.imp.DesignMode.bridge;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:45
 * @VERSION:1.0.0
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}

