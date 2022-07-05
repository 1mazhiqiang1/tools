package com.djhu.imp.utils;

/**
 * @Author mazq
 * @Date 2020/12/16 15:05
 */
public class HtmlToImage {

    public static void main(String[] args) throws Exception {

//        HtmlImgGenerator imageGenerator = new HtmlImgGenerator();




        //加载html模版
//        imageGenerator.loadHtml(htmlTemplate);

        //把html写入到图片
//        imageGenerator.saveAsImage("hello-world.png");

//        soffice.exe --headless --convert-to html ./test.xls
        String srcPath = "C:/Users/Administrator/Desktop/ppt/html/index.html";
        String command = "soffice --headless --convert-to pdf " + srcPath + " --outdir " + "D:/bbb.png";
        Process process = Runtime.getRuntime().exec(command);
        int result = process.waitFor();


    }

}
