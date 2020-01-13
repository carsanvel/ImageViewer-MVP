package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathPanel extends JPanel{
    
    private JTextField textField;

    public PathPanel() {
        add(new JLabel("New path: "));
        textField = new JTextField(40);
        add(textField);
    }
    
    public JTextField getTextField() {
        return textField;
    }
    
    public String getText() {
        return textField.getText();
    }
    
    
}
