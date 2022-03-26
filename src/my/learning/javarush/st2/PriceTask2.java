package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PriceTask2 {

    public static void task(String key){

        List<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            //String file = "src/my/learning/javarush/arrays/in.txt";
            BufferedReader filer = new BufferedReader(new FileReader(file));



    } catch (Exception e){
            e.printStackTrace();
        }
}
}
