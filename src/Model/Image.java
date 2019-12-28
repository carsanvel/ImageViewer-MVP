package Model;

public interface Image {
    
    String getName();
    byte[] getData();
    Image getNext();
    Image getPrev();
    
}
