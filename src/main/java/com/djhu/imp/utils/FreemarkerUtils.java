package com.djhu.imp.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.w3c.dom.Document;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author mazq
 * @Date 2020/12/16 16:15
 */
public class FreemarkerUtils {

/*
    spring:
    freemarker:
    cache: false
            # 字符集
    charset: UTF-8
            # 检查模板位置
    check-template-location: true
            # 模板内容类型
    content-type: text/html
    expose-request-attributes: true
    expose-session-attributes: true
    request-context-attribute: request
    # 模板位置
    template-loader-path: classpath:/templates*/

    public static String getTemplate(String template, Map<String,Object> map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        String templatePath = FreemarkerUtils.class.getResource("/").getPath()+"/templates";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        Template temp = cfg.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        stringWriter.flush();
        stringWriter.close();
        String resutl = stringWriter.getBuffer().toString();
        return resutl;
    }

//    public static void turnImage(String template, Map<String,Object> map, HttpServletResponse response) throws Exception {
    public static void turnImage(String template, Map<String,Object> map) throws Exception {
        String html = getTemplate(template, map);

        byte[] bytes=html.getBytes();
        ByteArrayInputStream bin=new ByteArrayInputStream(bytes);
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(bin);
        Java2DRenderer renderer = new Java2DRenderer(document,600,800);
        BufferedImage img = renderer.getImage();
//        response.setContentType("image/jpeg");
//        response.setDateHeader("expries", -1);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");
//        ImageIO.write(img, "jpg", response.getOutputStream());
        File file= new File("C:/Users/Administrator/Desktop/ppt/html/index2.jpg");

        ImageIO.write(img, "jpg", file);
    }



    public static void main(String[] args) {
        try {
            Map<String,Object> map=new HashMap<>();
            map.put("msg","html--生成图片测试");
            map.put("img","https://upload-images.jianshu.io/upload_images/912344-3054132dd6939004.png?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240");
            FreemarkerUtils.turnImage("index.ftl",map);
        } catch (Exception e) {
        }
    }
}
