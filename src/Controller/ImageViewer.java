package Controller;

import Model.Image;
import View.FileImageLoader;
import View.ImageDisplay;
import View.MainFrame;

public class ImageViewer {

    public static void main(String[] args) {
        
        FileImageLoader loader = new FileImageLoader("Europa");
        Image image = loader.load();
        MainFrame frame = new MainFrame();
        ImageDisplay display = frame.getImageDisplay();
        frame.addCommand(new NextCommand(display), "Next");
        frame.addCommand(new PrevCommand(display), "Prev");
        frame.addCommand(new ChangeCommand(display, frame.getPathPanel()), "Change");
        frame.execute();
        frame.getImageDisplay().display(image);
    }
    
}
