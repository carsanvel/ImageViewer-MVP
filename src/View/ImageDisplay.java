package View;

import Presenter.Listener;
import java.awt.image.BufferedImage;

public interface ImageDisplay {

    void display(BufferedImage bufferedImage);
    void display(BufferedImage buffered1, BufferedImage buffered2, int separation);
    void addListener(Listener listener);
    
}