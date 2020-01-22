package ViewSwingImplementation;

import View.PathPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingPathPanel extends JPanel implements PathPanel{

    private final JTextField textField;
    private final List<Listener> listeners;
    
    public SwingPathPanel() {
        listeners = new ArrayList<>();
        textField = new JTextField(40);
        add(new JLabel("New Path: "));
        add(textField);
        add(changeButton());
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public void setText(String text) {
        textField.setText(text);
    }

    private JButton changeButton() {
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(change());
        return changeButton;
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    private ActionListener change() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Listener listener : listeners) {
                    listener.changePath();
                }
            }
        };
    }

    
}
