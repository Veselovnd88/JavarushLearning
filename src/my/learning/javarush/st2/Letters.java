package my.learning.javarush.st2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Letters {

    public static void task(String [] args){
        String file = args[0];
        int count = 0;


        try {
            FileReader fr = new FileReader(file);
            int b;
            while((b=fr.read())!=-1){
                if(('a'<=b && b<='z')|| ('A'<=b && b<='Z')){
                    count++;
                }
            }fr.close();
            System.out.println(count);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
