package com.djhu.imp.LoadJavaFile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class URLPathClassLoader extends URLClassLoader{

    private String packageName = "priv.tuyou";

    public URLPathClassLoader(URL[] classPath, ClassLoader parent){

        super(classPath, parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> aClass = findLoadedClass(name);
        if(aClass != null){

            return aClass;
        }
        if(!packageName.startsWith(name)){

            return super.loadClass(name);
        }
        return null;
    }

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        URL[] urls = {new URL("file://Users/apple/temp")};
        URLPathClassLoader urlPathClassLoader = new URLPathClassLoader(urls, getSystemClassLoader());
        Class say = urlPathClassLoader.findClass("priv.tuyou.Say");
        Method method = say.getMethod("say");
        Object instance = say.newInstance();
        method.invoke(instance);

//        Say say2 = (Say)instance;
//        say2.say();
    }
}