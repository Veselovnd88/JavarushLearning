package my.learning.javarush.st2.serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TaskEasy implements Serializable {

    public static void task(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("src/my/learning/javarush/st2/out2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        TaskEasy solution = new TaskEasy();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("src/my/learning/javarush/st2/out2.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        TaskEasy loadedObject = (TaskEasy) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private  Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public TaskEasy() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
