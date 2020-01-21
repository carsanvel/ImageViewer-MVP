package Presenter;

import Model.Image;
import Model.ImageConverter;
import View.FileImageLoader;
import View.ImageDisplay;
import View.PathPanel;
import java.io.File;

public class ImagePresenter implements Listener{

    private Image currentImage;
    private final ImageDisplay imageDisplay;
    private final PathPanel pathPanel;

    public ImagePresenter(Image currentImage, ImageDisplay imageDisplay, PathPanel pathPanel) {
        this.currentImage = currentImage;
        this.imageDisplay = imageDisplay;
        this.pathPanel = pathPanel;
    }
    
    @Override
    public void nextImage() {
        currentImage = currentImage.getNext();
        imageDisplay.display(ImageConverter.imageOf(currentImage));
    }
    
    @Override
    public void prevImage() {
        currentImage = currentImage.getPrev();
        imageDisplay.display(ImageConverter.imageOf(currentImage));
    }
    
    @Override
    public void changePath() {
        String path = pathPanel.getText();
        if(new File(path).exists()) {
            currentImage = new FileImageLoader(path).load();
            imageDisplay.display(ImageConverter.imageOf(currentImage));
        } else {
            System.out.println("Wrong path");
        }
        pathPanel.setText("");
    }
    
    @Override
    public void slide(int pressedX, int draggedX, int lengthX) {
        int displacement = pressedX - draggedX;
        if(displacement > 0) {
            imageDisplay.display(ImageConverter.imageOf(currentImage), ImageConverter.imageOf(currentImage.getNext()), lengthX - displacement);
        } else {
           imageDisplay.display(ImageConverter.imageOf(currentImage.getPrev()), ImageConverter.imageOf(currentImage), -displacement); 
        }
    }

    
}
