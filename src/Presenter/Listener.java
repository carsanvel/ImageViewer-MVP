package Presenter;

public interface Listener {

    void nextImage();
    void prevImage();
    void changePath();
    void slide(int pressedX, int draggedX, int lengthX);
}
