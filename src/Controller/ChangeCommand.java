package Controller;

import View.FileImageLoader;
import View.ImageDisplay;
import View.PathPanel;

public class ChangeCommand implements Command{

    private final ImageDisplay display;
    private final PathPanel pathPanel;

    public ChangeCommand(ImageDisplay display, PathPanel pathPanel) {
        this.display = display;
        this.pathPanel = pathPanel;
    }
    
    @Override
    public void execute() {
        String path = pathPanel.getTextField().getText();
        display.display(new FileImageLoader(path).load());
        pathPanel.getTextField().setText("");
    }
    
}
