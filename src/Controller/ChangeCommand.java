package Controller;

import View.FileImageLoader;
import View.ImageDisplay;
import View.PathPanel;
import java.io.File;

public class ChangeCommand implements Command{

    private final ImageDisplay display;
    private final PathPanel pathPanel;

    public ChangeCommand(ImageDisplay display, PathPanel pathPanel) {
        this.display = display;
        this.pathPanel = pathPanel;
    }
    
    @Override
    public void execute() {
        String path = pathPanel.getText();
        if(new File(path).exists()) {
            display.display(new FileImageLoader(path).load());
        } else {
            System.out.println("Wrong path");
        }
        pathPanel.setText("");
    }
    
}
