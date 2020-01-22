package ImageViewer;

import View.ImageDisplay;
import View.PathPanel;
import ViewSwingImplementation.SwingImageDisplay;
import ViewSwingImplementation.SwingPathPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private SwingImageDisplay imageDisplay;
    private PathPanel pathPanel;
    
    public MainFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        initializeDisplay();
        initializePathPanel();
    }


    public void execute() {
        setVisible(true);
    }

    private void initializeDisplay() {
        getContentPane().add(imageDisplay(), BorderLayout.CENTER);
    }
    
    private JPanel imageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay = display;
        return display;
    }

    private void initializePathPanel() {
        getContentPane().add(pathPanel(), BorderLayout.SOUTH);
    }

    
    private JPanel pathPanel() {
        SwingPathPanel panel = new SwingPathPanel();
        pathPanel = panel;
        return panel;
    }
    
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
    public PathPanel getPathPanel() {
        return pathPanel;
    }

    
}
