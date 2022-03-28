package my.learning.javarush.st2;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream  implements AmigoStringWriter{
    private FileOutputStream fos;
    public static void task(){

    }
    public AdapterFileOutputStream(FileOutputStream fos){
        this.fos = fos;
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fos.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }
}
