package my.learning.javarush.st2;

import java.io.*;

public class NotFound {


    public static void task() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String file = br.readLine();
            try(
             FileInputStream fis = new FileInputStream(file);
            ) {

            } catch (FileNotFoundException f){
                System.out.println(file);
                break;
            }
        }
    }
}