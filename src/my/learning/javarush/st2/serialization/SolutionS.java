package my.learning.javarush.st2.serialization;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolutionS implements Externalizable {
    public static void task(){
        try {
            InputStream is = new FileInputStream("src/my/learning/javarush/st2/out1.txt");
            OutputStream os = new FileOutputStream("src/my/learning/javarush/st2/out1.txt");
            SolutionS savedObject = new SolutionS(100);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
            savedObject.writeExternal(oos);
            SolutionS another = new SolutionS(500);
            another.readExternal(ois);
            System.out.println(savedObject.string.equals(another.string));


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date  currentDate;
    private transient int temperature;
    String string;

    public SolutionS(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this. string = (String) in.readObject();
    }
}
