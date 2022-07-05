package com.djhu.imp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:mzq
 * @DATE:2019/8/1510:31
 * @VERSION:1.0.0
 */
public class ScriptCall {
    public static void main(String[] args) {
//
//    }
//    public static  void invokeShell(){
//方法1 执行字符串命令（各个参数1234之间需要有空格）
        String path="D:\\zookeeper-3.4.10\\bin\\zkServer.cmd ";
//方法2 在单独的进程中执行指定命令和变量。
//第一个变量是sh命令，第二个变量是需要执行的脚本路径，从第三个变量开始是我们要传到脚本里的参数。
//        String[] path=new String[]{"sh","/root/zpy/zpy.sh","1","2","3","4"};
        try{
            Runtime runtime = Runtime.getRuntime();
            Process pro = runtime.exec(path);
            int status = pro.waitFor();
            if (status != 0)
            {
                System.out.println("Failed to call shell's command");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            StringBuffer strbr = new StringBuffer();
            String line;
            while ((line = br.readLine())!= null)
            {
                strbr.append(line).append("\n");
            }

            String result = strbr.toString();
            System.out.println(result);

        }
        catch (IOException ec)
        {
            ec.printStackTrace();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();

        }
    }
}
