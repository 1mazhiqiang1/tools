package com.djhu.imp.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author mazq
 * @Date 2020/11/4 18:10
 */
public class PdfToImage2 {

    public static void main(String[] args) {
     /*   PdfDecoder decode_pdf = new PdfDecoder(true);
        try {
            decode_pdf.openPdfFile("c:\\test.pdf"); //file
//　　　decode_pdf.openPdfFile("C:/jpedalPDF.pdf", "password"); //encrypted file
//      decode_pdf.openPdfArray(bytes); //bytes is byte[] array with PDF
//      decode_pdf.openPdfFileFromURL("http://www.mysite.com/jpedalPDF.pdf",false);
//      decode_pdf.openPdfFileFromInputStream(in, false);

            int start = 1, end = decode_pdf.getPageCount();
            for (int i = start; i < end + 1; i++) {
                BufferedImage img = decode_pdf.getPageAsImage(i);
                try {
                    ImageIO.write(img, "png", new File("C:\\jpedal_image.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            decode_pdf.closePdfFile();
        } catch (PdfException e) {
            e.printStackTrace();
        }*/

        pdf2png("C:\\Users\\Administrator\\Desktop\\ppt","2020_PDF","jpeg");
    }


    /**
     * 转换全部的pdf
     * @param fileAddress 文件地址
     * @param filename PDF文件名
     * @param type 图片类型
     */
    public static void pdf2png(String fileAddress,String filename,String type) {
        // 将pdf装图片 并且自定义图片得格式大小
        File file = new File(fileAddress+"\\"+filename+".pdf");
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
                // BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
                ImageIO.write(image, type, new File(fileAddress+"\\"+filename+"_"+(i+1)+"."+type));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *自由确定起始页和终止页
     * @param fileAddress 文件地址
     * @param filename pdf文件名
     * @param indexOfStart 开始页  开始转换的页码，从0开始
     * @param indexOfEnd 结束页  停止转换的页码，-1为全部
     * @param type 图片类型
     */
    public static void pdf2png(String fileAddress,String filename,int indexOfStart,int indexOfEnd,String type) {
        // 将pdf装图片 并且自定义图片得格式大小
        File file = new File(fileAddress+"\\"+filename+".pdf");
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = indexOfStart; i < indexOfEnd; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
                // BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
                ImageIO.write(image, type, new File(fileAddress+"\\"+filename+"_"+(i+1)+"."+type));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
