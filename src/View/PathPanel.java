package View;

public interface PathPanel {

    String getText();
    void setText(String text);
    void addListener(Listener listener);
    
    public interface Listener {
        public void changePath();
    }
}
