package Presenter;

import Model.Image;
import Model.ImageConverter;
import View.FileImageLoader;
import View.ImageDisplay;
import View.MainFrame;

public class ImageViewer {

    public static void main(String[] args) {
        
        FileImageLoader loader = new FileImageLoader("Europa");
        Image image = loader.load();
        MainFrame frame = new MainFrame();
        ImageDisplay display = frame.getImageDisplay();
        ImagePresenter presenter = new ImagePresenter(image, display, frame.getPathPanel());
        display.addListener(presenter);
        frame.addListener(presenter);
        display.display(ImageConverter.imageOf(image));
        frame.execute();
        
    }
    
}
