package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class PricesTask {

    public static void task(String key, String productName, String price, String quantity){
        try{
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String file = br.readLine();
            String file = "src/my/learning/javarush/arrays/in.txt";
            FileReader fr = new FileReader(file);
            String id = null;
            char[] a = new char[42];
            while(fr.read()!=-1){
            fr.read(a);
              //  for(char c: a){
                //    System.out.print(c);}
            } fr.close();




        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
