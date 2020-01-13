package Controller;

import View.ImageDisplay;

public class PrevCommand implements Command{

    private ImageDisplay display;
    
    public PrevCommand(ImageDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.display(display.getCurrentImage().getPrev());
    }
    
}
