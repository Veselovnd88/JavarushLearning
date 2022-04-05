package my.learning.javarush.st2.serialization;

import java.io.*;

public class InTheThread implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String file;

    public InTheThread(String fileName) throws FileNotFoundException {
        this.file = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(file);
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       // String filename = (String) in.readObject();
        this.stream = new FileOutputStream(file,true);

        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void task(String[] args) {
        try{

        InTheThread th = new InTheThread("src/my/learning/javarush/st2/out2.txt");
        th.writeObject("Hello World");
        OutputStream os = new FileOutputStream("src/my/learning/javarush/st2/serialization/ser.dat");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(th);
        InputStream is = new FileInputStream("src/my/learning/javarush/st2/serialization/ser.dat");
        ObjectInputStream ois = new ObjectInputStream(is);

        InTheThread loaded = (InTheThread) ois.readObject();
        loaded.writeObject("Bye Bye");


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
