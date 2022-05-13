package my.learning.javarush.st3.shortener.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(this.path);
            Files.createFile(this.path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } this.path.toFile().deleteOnExit();

        }

    public Long getFileSize() {
        try {
            return Files.size(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void putEntry(Entry entry) {

        try {
            OutputStream os = Files.newOutputStream(this.path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(entry);
            oos.close();
            os.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Entry getEntry(){
        try {
            if (Files.size(this.path)==0){
                return null;
            }
            else{
                InputStream is = Files.newInputStream(this.path);
                ObjectInputStream ois = new ObjectInputStream(is);
                Entry e = (Entry) ois.readObject();
                return e;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void remove(){
        try {
            Files.delete(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
