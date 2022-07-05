package com.djhu.imp.LoadJavaFile;

import com.itranswarp.compiler.JavaStringCompiler;
import org.nutz.lang.Lang;
import org.nutz.lang.util.NutMap;

import java.util.Map;

/**
 * Created by zhu on 17-8-5.
 */
public class Test {

    /**
     * ORM 相关 示例
     *
     * @param args
     */

    public static void main(String[] args) {


        try {

            JavaStringCompiler compiler = new JavaStringCompiler();

            //1个java文件里面可能有多个类,但是只能 有1个public的类
            Map<String, byte[]> results = compiler.compile("User.java", JAVA_SOURCE_CODE);
            Class<?> clazz = compiler.loadClass("net.javablog.vo.User", results);


            Object userobj = clazz.newInstance();
            NutMap user = Lang.obj2nutmap(userobj);
            System.out.println(user);


        } catch (Exception e) {
        }


    }

    static final String JAVA_SOURCE_CODE =
            "package net.javablog.vo;" +
                    "public class User {" +
                    "" +
                    "private String id=\"zhang\";" +
                    "private String name=\"张三\";" +
                    "private long created=1234L;" +
                    "" +
                    "public String getId() {" +
                    "return id;" +
                    "}" +
                    "" +
                    "public void setId(String id) {" +
                    "this.id = id;" +
                    "}" +
                    "" +
                    "public String getName() {" +
                    "return name;" +
                    "}" +
                    "" +
                    "public void setName(String name) {" +
                    "this.name = name;" +
                    "}" +
                    "" +
                    "public long getCreated() {" +
                    "return created;" +
                    "}" +
                    "" +
                    "public void setCreated(long created) {" +
                    "this.created = created;" +
                    "}" +
                    "" +
                    "} ";


}
