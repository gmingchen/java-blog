package com.slipper.common.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 水印
 * @author gumingchen
 */
public class Watermark {

    /**
     * 文字水印
     * @param path 图片路径
     * @param text 水印文字
     * @return
     */
    public static void printText(String path, String text) {
        try {
            File file = new File(path);
            Image image = ImageIO.read(file);
            int width = image.getWidth(null);
            int height = image.getHeight(null);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(image, 0, 0, width, height, null);
            graphics.setColor(new Color(0, 0, 0, 30));
            graphics.setFont(new Font("宋体", Font.PLAIN, 12));
            graphics.drawString(text, 3, height - 3);
            graphics.dispose();

            FileOutputStream out = new FileOutputStream(path);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(bufferedImage);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
