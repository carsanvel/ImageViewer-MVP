package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingPathPanel extends JPanel implements PathPanel {
    
    private JTextField textField;

    public SwingPathPanel() {
        add(new JLabel("New path: "));
        textField = new JTextField(40);
        add(textField);
    }
    
    @Override
    public String getText() {
        return textField.getText();
    }
    
    @Override
    public void setText(String text) {
        textField.setText(text);
    }
    
    
}
