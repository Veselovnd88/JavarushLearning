package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticFileTask {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String line;
            while (!((line = br.readLine()) ==null)){
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void task(){
        System.out.println(lines);

    }
}
