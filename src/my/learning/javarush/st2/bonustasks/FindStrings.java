package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindStrings {
    public static List<String> words = new ArrayList<String>();
    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }


    public static void task(){
        List<Integer> indexes = new ArrayList<>();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try{
            String file = console.readLine();
            FileReader fr = new FileReader(file);
            BufferedReader brFr = new BufferedReader(fr);

            while(brFr.ready()){
                int count=0;
                String line = brFr.readLine();
                String[] parts = line.split(" ");
                for(String s:parts){
                    if(words.contains(s)){
                        count++;
                    }
                } if (count==2){
                    System.out.println(line);
                }
            } brFr.close();
                fr.close();
                console.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
