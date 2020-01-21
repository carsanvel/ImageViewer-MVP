package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingPathPanel extends JPanel implements PathPanel{

    private final JTextField textField;
    
    public SwingPathPanel() {
        textField = new JTextField(40);
        add(new JLabel("New Path: "));
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
