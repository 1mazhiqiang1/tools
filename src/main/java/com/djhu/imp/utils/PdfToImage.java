/*
package com.djhu.imp.utils;


public class PdfToImage {

    public static void main(String[] args) {
        String filePath = "c:/test.pdf";
        Document document = new Document();
        document.setFile(filePath);
        float scale = 2.5f;//缩放比例
        float rotation = 0f;//旋转角度

        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = (BufferedImage)
                    document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
            RenderedImage rendImage = image;
            try {
                File file = new File("c:/iecPDF_" + i + ".png");
                ImageIO.write(rendImage, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.flush();
        }
        document.dispose();
    }
}
*/
