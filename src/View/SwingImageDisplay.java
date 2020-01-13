package View;

import Model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image currentImage;
    
    @Override
    public void display(Image image) {
        currentImage = image;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(imageOf(currentImage), 0, 0, getWidth(), getHeight(), null);
    }
    
    private BufferedImage imageOf(Image image) {
        ByteArrayInputStream is = new ByteArrayInputStream(image.getData());
        try {
            return ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Image getCurrentImage() {
        return currentImage;
    }
    
}
