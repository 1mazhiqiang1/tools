package com.djhu.imp.LoadJavaFile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:mzq
 * @DATE:2019/9/2713:46
 * @VERSION:1.0.0
 */
public class TestLoadJavaFile {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String classPath = "D:\\TestLoadJavaFile";
        String className = "HelloIvan";

        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        Class clazz = myClassLoader.findClass(className);
        //获取类对象
        Object object = clazz.newInstance();
        //获取类方法
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method:methods){
            //类对象调用方法
            method.invoke(object);
        }
    }

}
