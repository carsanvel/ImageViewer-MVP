package View;

import Controller.ChangeCommand;
import Controller.Command;
import Controller.NextCommand;
import Controller.PrevCommand;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private SwingImageDisplay display;
    private Map<String, Command> commands;
    private PathPanel pathPanel;
    
    public MainFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        execute();
        setVisible(true);
    }

    private void execute() {
        initializeDisplay();
        initializeToolBar();
        initializeCommands();
    }

    private void initializeDisplay() {
        display = new SwingImageDisplay();
        getContentPane().add(display, BorderLayout.CENTER);
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
        JPanel pathChangePanel = new JPanel();
        pathPanel = new PathPanel();
        pathChangePanel.add(pathPanel);
        pathChangePanel.add(changePathButton());
        toolBarPanel.add(pathChangePanel, BorderLayout.SOUTH);
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
        return display;
    }

    private void initializeCommands() {
        commands = new HashMap<>();
        commands.put("Next", new NextCommand(display));
        commands.put("Prev", new PrevCommand(display));
        commands.put("Change", new ChangeCommand(display, pathPanel));
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
