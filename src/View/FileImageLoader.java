package View;

import Model.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class FileImageLoader implements ImageLoader {
    
    private File[] files;
    private int index;
    String path;
    
    public FileImageLoader(String path) {
        this.path = path;
        index = 0;
    }
    
    @Override
    public void load() {
        files = new File(path).listFiles();
    }
    
    public Image imageAt(int index) {
        return new Image(){
            
            private String name = files[index].getName();
            private byte[] data = readFile();
            
            public String getName() {
                return name;
            }
            
            public byte[] getData() {
                return data;
            }
            
            public Image getNext() {
                return null;
            }
            
            public Image getPrev() {
                return null;
            }
        };
    }
    
    private byte[] readFile(BufferedInputStream is) {
        byte[] buffer = new byte[4096];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            while(true) {
                int length = is.read(buffer);
                os.write(buffer, 0, length);
                if(length < 0) {
                    break;
                }
            }
            buffer.flush();
        }
        catch(IOException e) {
            return null;
        }
    }
}
