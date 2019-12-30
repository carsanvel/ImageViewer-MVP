package imageviewer;

import Model.Image;
import View.FileImageLoader;

public class ImageViewer {

    public static void main(String[] args) {
        
        FileImageLoader loader = new FileImageLoader("C:\\Users\\carvsk\\Documents\\universidad\\Cuarto ano\\Primer cuatrimestre\\Ingeniería del software 2\\Imagenes");
        Image image = loader.load();
        for (int i = 0; i < 10; i++) {
            System.out.println(image.getName() + "\n" + image.getData().length);
            image = image.getNext();
        }
    }
    
}
