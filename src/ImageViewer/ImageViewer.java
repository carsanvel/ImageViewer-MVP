package ImageViewer;

import Model.Image;
import Presenter.ImagePresenter;
import View.ImageConverter;
import View.FileImageLoader;
import View.ImageDisplay;

public class ImageViewer {
    
    public static void main(String[] args) {
        
        FileImageLoader loader = new FileImageLoader("Europa");
        Image image = loader.load();
        MainFrame frame = new MainFrame();
        ImageDisplay display = frame.getImageDisplay();
        ImagePresenter presenter = new ImagePresenter(image, display, frame.getPathPanel());
        display.display(ImageConverter.imageOf(image));
        frame.execute();
        
    }
    
}
