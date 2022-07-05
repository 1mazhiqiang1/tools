package com.djhu.imp.utils;

import com.djhu.imp.service.Config;
import javassist.Modifier;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author:mzq
 * @DATE:2019/9/618:24
 * @VERSION:1.0.0
 */
public class ImplementClassesOfInterfaceUtil {

    // 初始化方法名称
    private static final String INIT_METHOD_NAME = "initialize";
    // 要扫描的包名
    private static final String PACKAGE_NAME     = "com.djhu.imp.service";


    /**
     * 获取所有模块名称
     *
     * @return
     */
    public static List<String> getConfigNameList() {
        List<String> nameList = new ArrayList<String>();
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Set<Class<? extends Config>> classes = reflections.getSubTypesOf(Config.class);
            for (Class<? extends Config> config: classes) {
                boolean isAbstract = Modifier.isAbstract(config.getModifiers());
                //过滤抽象类
                if (!isAbstract) {
                    nameList.add(config.getName());
                }
            }
        return nameList;
    }


    /**
     * 调用初始化方法
     *
     * @param fullClassName 全限定名
     */
    @SuppressWarnings("unchecked")
    public static Config manualInitialize(String fullClassName) {
        try {
            Class clazz = Class.forName(fullClassName);
            Config obj = (Config)clazz.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        List<String> list = getConfigNameList();
        for (String name : list) {
            System.out.println(name);
            //初始化
            Config config = manualInitialize(name);
        }
    }
}
