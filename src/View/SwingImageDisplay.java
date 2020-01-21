package View;

import Presenter.Listener;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private BufferedImage bufferedImage1;
    private BufferedImage bufferedImage2;
    private final List<Listener> listeners;
    private int separation;
    private int pressedPositionX;
    private int draggedPositionX;
    
    
    public SwingImageDisplay() {
        CompleteMouseListener mouseListener  = new CompleteMouseListener();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        listeners = new ArrayList<>();
    }
    
    @Override
    public void display(BufferedImage image) {
        bufferedImage1 =  image;
        bufferedImage2 =  null;
        repaint();
    }
    
    @Override
    public void display(BufferedImage image1, BufferedImage image2, int separation) {
        bufferedImage1 =  image1;
        bufferedImage2 =  image2;
        this.separation = separation;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        if(bufferedImage2 == null) {
            g.drawImage(bufferedImage1, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.drawImage(bufferedImage1, 0, 0, separation, getHeight(), null);
            g.drawImage(bufferedImage2, separation + 1, 0, getWidth(), getHeight(), null);
        }
    }
    
    
    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    
    private class CompleteMouseListener implements MouseListener, MouseMotionListener {

        private boolean dragged = false;
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedPositionX = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(dragged) {
                int displacement = pressedPositionX - draggedPositionX;
                if(displacement > 0) {
                    if(displacement >= getWidth()/2) {
                        for (Listener listener : listeners) {
                            listener.nextImage();
                        }
                    } else {
                        display(bufferedImage1);
                    }
                } 
                if(displacement < 0 ){
                    if(Math.abs(displacement) >= getWidth()/2) {
                        for (Listener listener : listeners) {
                            listener.prevImage();
                        }
                    } else {
                        display(bufferedImage2);
                    }
                }
                
            }
            dragged = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            dragged = true;
            draggedPositionX = e.getX();
            for (Listener listener : listeners) {
                listener.slide(pressedPositionX, draggedPositionX, getWidth());
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
        
    }


    
}
