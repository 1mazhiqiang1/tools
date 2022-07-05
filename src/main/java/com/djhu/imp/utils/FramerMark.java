package com.djhu.imp.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:mzq
 * @DATE:2019/9/1618:02
 * @VERSION:1.0.0
 */
public class FramerMark {
    public static void main(String[] args) {
        //动态配置短信模板内容！
        try {
            Map<String, String> map = new HashMap<String, String>();
            //volity

            //短信模板
            String templateString = "${username}/zhangsan";
            Template t = new Template("name1", new StringReader(templateString), new Configuration());
            //具体填充内容
            map.put("username", "lisi");
            StringWriter result = new StringWriter();
            t.process(map, result);
            System.out.println(result.toString());

//            stringToHtml();

            setNewDescription();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stringToHtml(){
        //用于存储html字符串
        StringBuilder stringHtml = new StringBuilder();
        try{
            //打开文件
            PrintStream printStream = new PrintStream(new FileOutputStream("C:/Users/Administrator/Desktop/ppt/2020/test.html"));
            //输入HTML文件内容
            stringHtml.append("<html><head>");
            stringHtml.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">");
            stringHtml.append("<title>测试报告文档</title>");
            stringHtml.append("</head>");
            stringHtml.append("<body>");
            stringHtml.append("<div>hello    ${username}/zhangsan  " +
                    "<img src=\"https://profile.csdnimg.cn/2/2/9/3_u010312671\"" +
                    "   </div>");
            stringHtml.append("</body></html>");
            String templateString = stringHtml.toString();
            Template t = new Template("name1", new StringReader(templateString), new Configuration());
            //具体填充内容
            Map<String, String> map = new HashMap<String, String>();
            map.put("username", "lisi");
            StringWriter result = new StringWriter();
            t.process(map, result);
            //将HTML文件内容写入文件中
            printStream.println(result.toString());
            printStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void setNewDescription() {
//    public  void setNewDescription(File file) {

       File file = new File("C:/Users/Administrator/Desktop/ppt/html/index.html");
        //用于存储html字符串
        StringBuilder stringHtml = new StringBuilder();

        String line;
        boolean found = false;
        try {
            //打开文件
            PrintStream printStream = new PrintStream(new FileOutputStream("C:/Users/Administrator/Desktop/ppt/html/index2.html"));
            FileInputStream iStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(iStream);
            BufferedReader htmlReader = new BufferedReader(reader);
            while (!found && (line = htmlReader.readLine()) != null) {
                stringHtml.append(line);
            }
            //填充字符串内容
            String templateString = stringHtml.toString();
            Template t = new Template("name1", new StringReader(templateString), new Configuration());
            //具体填充内容
            Map<String, String> map = new HashMap<String, String>();
            map.put("entrpriseName", "企业名称动态设置");
            StringWriter result = new StringWriter();
            t.process(map, result);
            //将HTML文件内容写入文件中
            printStream.println(result.toString());
            printStream.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public static void stringToHtml2(String str){
        //用于存储html字符串
        StringBuilder stringHtml = new StringBuilder();
        try{
            //打开文件
            PrintStream printStream = new PrintStream(new FileOutputStream("./Data/test.html"));
            //输入HTML文件内容
            stringHtml.append("<html><head>");
            stringHtml.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">");
            stringHtml.append("<title>测试报告文档</title>");
            stringHtml.append("</head>");
            stringHtml.append("<body>");
            stringHtml.append("<div>hello</div>");
            stringHtml.append("</body></html>");
            //将HTML文件内容写入文件中
            printStream.println(stringHtml.toString());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
