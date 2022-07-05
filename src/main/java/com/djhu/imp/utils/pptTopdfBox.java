package com.djhu.imp.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author mazq
 * @Date 2020/12/2 11:56
 */
public class pptTopdfBox {
    public static void main(String[] args) {
        try {
            int dpi = 296;
            PDDocument pdDocument = PDDocument.load(new File("C:\\Users\\Administrator\\Desktop\\ppt\\diyitianzuoye.pptx"));
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pageCount = pdDocument.getNumberOfPages();
            /* dpi越大转换后越清晰，相对转换速度越慢 */
            for (int i = 0; i < pageCount; i++) {
                File dstFile = new File("C:\\Users\\Administrator\\Desktop\\ppt\\\\images\\"+i);
                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                ImageIO.write(image, "png", dstFile);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
