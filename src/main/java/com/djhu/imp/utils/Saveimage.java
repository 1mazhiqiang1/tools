/*
import com.spire.presentation.Presentation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Saveimage {
    public static void main(String[] args) throws Exception {
        String inputFile = "C:\\Users\\Test1\\Desktop\\测试文档.pptx";
        String outputPath = "output/";
        //创建实例
        Presentation ppt = new Presentation();
        //加载文件
        ppt.loadFromFile(inputFile);
        for (int i = 0; i < ppt.getSlides().get(0).getShapes().getCount(); i++)
        {
            String fileName = outputPath + String.format("shapeToImage-%1$s.png", i);
            //将shape保存为image对象
            BufferedImage image = ppt.getSlides().get(0).getShapes().saveAsImage(i);
            //写出图片
            ImageIO.write(image, "PNG",  new File(fileName));
        }
    }
}*/
