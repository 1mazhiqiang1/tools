package com.djhu.imp.LoadJavaFile;

import com.itranswarp.compiler.JavaStringCompiler;
import org.nutz.lang.Mirror;

import java.util.Map;

/**
 * Created by zhu on 17-8-5.
 */
public class Test02 {


    /**
     * java 脚本引擎  示例
     *
     * @param args
     */
    public static void main(String[] args) {


        try {
            JavaStringCompiler compiler = new JavaStringCompiler();

            //1个java文件里面可能有多个类,但是只能 有1个public的类
            Map<String, byte[]> results = compiler.compile("Calc.java", JAVA_SOURCE_CODE);
            Class<?> clazz = compiler.loadClass("net.javablog.ut.Calc", results);


            Object calc = clazz.newInstance();

            //执行 1+2  , 最终会输出3
            System.out.println(Mirror.me(clazz).invoke(calc, "sum", 1, 2));


        } catch (Exception e) {

        }


    }

    static final String JAVA_SOURCE_CODE =
            "package net.javablog.ut;" +
                    "public class Calc {" +
                    "" +
                    "    public int sum(int a, int b) {" +
                    "        return a + b;" +
                    "    }" +
                    "" +
                    "} ";


}
