package View;

import Controller.Command;
import Controller.NextCommand;
import Controller.PrevCommand;
import Model.Image;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
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
        initializeButtons();
        initializeCommands();
    }

    private void initializeDisplay() {
        display = new SwingImageDisplay();
        getContentPane().add(display, BorderLayout.CENTER);
    }

    private void initializeButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(prevButton());
        buttonsPanel.add(nextButton());
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
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
    
    public ImageDisplay getImageDisplay() {
        return display;
    }

    private void initializeCommands() {
        commands = new HashMap<>();
        commands.put("Next", new NextCommand(display));
        commands.put("Prev", new PrevCommand(display));
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
}
