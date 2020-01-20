package View;

import Controller.Command;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private SwingImageDisplay imageDisplay;
    private Map<String, Command> commands;
    private PathPanel pathPanel;
    
    public MainFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        commands = new HashMap<>();
        initializeDisplay();
        initializeToolBar();
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

    private void initializeToolBar() {
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.setLayout(new BorderLayout());
        initializeMoveButtons(toolBarPanel);
        initializePathChangeBar(toolBarPanel);
        getContentPane().add(toolBarPanel, BorderLayout.SOUTH);
    }

    private void initializeMoveButtons(JPanel toolBarPanel) {
        JPanel moveButtonsPanel =  new JPanel();
        moveButtonsPanel.add(prevButton());
        moveButtonsPanel.add(nextButton());
        toolBarPanel.add(moveButtonsPanel, BorderLayout.CENTER);
    }
    
    private void initializePathChangeBar(JPanel toolBarPanel) {
        pathPanel = new SwingPathPanel();
        toolBarPanel.add(pathPanel(), BorderLayout.SOUTH);
    }
    
    private JPanel pathPanel() {
        SwingPathPanel panel = new SwingPathPanel();
        panel.add(changePathButton());
        pathPanel = panel;
        return panel;
    }
    
    private JButton prevButton() {
        JButton prevButton = new JButton("<=");
        prevButton.addActionListener(prevImage());
        return prevButton;
    }
    
    private JButton nextButton() {
        JButton nextButton = new JButton("=>");
        nextButton.addActionListener(nextImage());
        return nextButton;
    }
    
    private JButton changePathButton() {
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(changePath());
        return changeButton;
    }
    
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
    public PathPanel getPathPanel() {
        return pathPanel;
    }

    public void addCommand(Command command, String name) {
        commands.put(name, command);
    }
    
    private ActionListener nextImage() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Next").execute();
            }
            
        };
    }
    
    private ActionListener prevImage() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Prev").execute();
            }
            
        };
    }

    private ActionListener changePath() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Change").execute();
            }
        };
    }

}
