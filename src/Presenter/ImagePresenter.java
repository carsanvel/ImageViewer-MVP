package Presenter;

import Model.Image;
import View.ImageConverter;
import View.FileImageLoader;
import View.ImageDisplay;
import View.PathPanel;
import java.io.File;

public class ImagePresenter{

    private Image currentImage;
    private final ImageDisplay imageDisplay;
    private final PathPanel pathPanel;

    public ImagePresenter(Image currentImage, ImageDisplay imageDisplay, PathPanel pathPanel) {
        this.currentImage = currentImage;
        this.imageDisplay = imageDisplay;
        this.pathPanel = pathPanel;
        imageDisplay.addListener(displayListener());
        pathPanel.addListener(pathPanelListener());
    }
    
    public Image next() {
        currentImage = currentImage.getNext();
        return currentImage;
    }
    
    public Image prev() {
        currentImage = currentImage.getPrev();
        return currentImage;
    }

    public Image getCurrentImage() {
        return currentImage;
    }
    
    public void setCurrentImage(Image image) {
        currentImage = image;
    }

    private ImageDisplay.Listener displayListener() {
        return new ImageDisplay.Listener() {
            
            @Override
            public void nextImage() {
                imageDisplay.display(ImageConverter.imageOf(next()));
            }

            @Override
            public void prevImage() {
                imageDisplay.display(ImageConverter.imageOf(prev()));
            }

            @Override
            public void slide(int pressedX, int draggedX, int lengthX) {
                int displacement = pressedX - draggedX;
                Image image =  getCurrentImage();
                if(displacement > 0) {
                    imageDisplay.display(ImageConverter.imageOf(image), ImageConverter.imageOf(image.getNext()), lengthX - displacement);
                } else {
                    imageDisplay.display(ImageConverter.imageOf(image.getPrev()), ImageConverter.imageOf(image), -displacement); 
                }
            }
            
        };
    }

    private PathPanel.Listener pathPanelListener() {
        return new PathPanel.Listener() {

            @Override
            public void changePath() {
                String path = pathPanel.getText();
                if(new File(path).exists()) {
                    Image image = new FileImageLoader(path).load();
                    imageDisplay.display(ImageConverter.imageOf(image));
                    setCurrentImage(image);
                } else {
                    System.out.println("Wrong path");
                }
                pathPanel.setText("");
            }
        };
    }

    
}
