package com.djhu.imp.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author mazq
 * @Date 2020/12/3 14:21
 */
public class LibreOffice2PNG {

        //现将ppt转pdf 在将pdf转图片
        public static void main(String[] args) throws NullPointerException {
            long start = System.currentTimeMillis();
//            String srcPath = "C:/Users/Desktop/test.pptx", desPath = "C:/Users/Desktop/test";
            String srcPath = "C:/Users/Administrator/Desktop/ppt/toPdf/diyitianzuoye2.pptx", desPath = "C:/Users/Administrator/Desktop/ppt/toPdf";
            String command = "";
            String osName = System.getProperty("os.name");
            if (osName.contains("Windows")) {
//                command = "soffice --headless --convert-to pdf " + srcPath + " --outdir " + desPath+"\\\\test.pdf";
//                command = "C:/Program Files/LibreOffice/program/soffice --headless   --convert-to pdf " + srcPath + " --outdir " + desPath;
                command = "soffice --headless --convert-to pdf "+"C:/Users/Administrator/Desktop/ppt/toPdf/diyitianzuoye2.pptx"+" --outdir "+"C:/Users/Administrator/Desktop/ppt/toPdf";
                exec(command);
            }

            pdf2png(desPath+"/"+"diyitianzuoye2.pdf");
            long end = System.currentTimeMillis();
        }

        public static void exec(String command) {
            Process process;
            try {
                process = Runtime.getRuntime().exec(command);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("转换异常");
            }
        }

        public static void pdf2png(String filePath) {
            File file = new File(filePath);
            try {
                PDDocument doc = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(doc);
                int pageCount = doc.getNumberOfPages();
                for (int i = 0; i < pageCount; i++) {
                    BufferedImage image = renderer.renderImageWithDPI(i, 95);
//                    OutputStream out=new FileOutputStream(new File("D:/image/"+(i+1)+".png"));
                    OutputStream out=new FileOutputStream(new File("C:/Users/Administrator/Desktop/ppt/images/"+(i+1)+".png"));
                    ImageIO.write(image, "png", out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

