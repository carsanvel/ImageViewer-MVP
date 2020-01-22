package View;

import Model.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageConverter {

    public static BufferedImage imageOf(Image image) {
        ByteArrayInputStream is = new ByteArrayInputStream(image.getData());
        try {
            return ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
