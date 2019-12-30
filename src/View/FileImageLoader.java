package View;

import Model.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileImageLoader implements ImageLoader {
    
    private final File[] files;
    
    public FileImageLoader(String path) {
        files = new File(path).listFiles();
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }
    
    private Image imageAt(int index) {
        return new Image(){
                     
            @Override
            public String getName() {
                return files[index].getName();
            }
            
            @Override
            public byte[] getData() {
                try {
                    return readFile(new BufferedInputStream(new FileInputStream(files[index])));
                }
                catch(FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
            
            @Override
            public Image getNext() {
                return imageAt((index + 1) % files.length);
            }
            
            @Override
            public Image getPrev() {
                return imageAt((index - 1 + files.length) % files.length);
            }
            
            private byte[] readFile(BufferedInputStream is) {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                try {
                    while(true) {
                        int length = is.read(buffer);
                        if(length < 0) {
                            break;
                        }
                        os.write(buffer, 0, length);
                    }
                    byte[] result  = os.toByteArray();
                    os.close();
                    return result;
                }
                catch(IOException e) {
                    return null;
                }
            }
            
        };
    }
}
