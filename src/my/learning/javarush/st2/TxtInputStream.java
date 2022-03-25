package my.learning.javarush.st2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtInputStream extends FileInputStream {


    public TxtInputStream(String name, FileInputStream fis) throws IOException, UnsupportedFileNameException {
        super(name);

        if(!name.endsWith(".txt")){
            super.close();
            throw  new UnsupportedFileNameException();
        }

    }
}
