package com.djhu.imp.DesignMode.adapter.SourceableInterface;

/**
 * @Author:mzq
 * @DATE:2019/8/1517:15
 * @VERSION:1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

}
