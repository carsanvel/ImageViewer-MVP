package Controller;

import Model.Image;
import View.FileImageLoader;
import View.MainFrame;

public class ImageViewer {

    public static void main(String[] args) {
        
        FileImageLoader loader = new FileImageLoader("Europa");
        Image image = loader.load();
        MainFrame frame = new MainFrame();
        frame.getImageDisplay().display(image);
    }
    
}
