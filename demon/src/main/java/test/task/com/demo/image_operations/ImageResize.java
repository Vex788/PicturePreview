package test.task.com.demo.image_operations;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class ImageResize {

    private static String getPictureFormat(String pictureName) {
        return pictureName.substring(pictureName.lastIndexOf(".") + 1);
    }

    private static void resize(String pathToPicture) throws IOException {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(new File(pathToPicture))
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIO.write(img, getPictureFormat(pathToPicture), new File(pathToPicture));
    }

    public static void resize(Collection<String> pathToPictures) {
        try {
            for (String pathToPic : pathToPictures) {
                resize(pathToPic);
            }
        } catch (Exception ex) {
            System.out.println("ImageResize>resize\n" + ex.toString());
        }
    }
}
