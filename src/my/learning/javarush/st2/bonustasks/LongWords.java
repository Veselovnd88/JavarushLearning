package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class LongWords {

    public static void task(String[] args){
        String file1 = args[0];
        String file2 = args[1];
        try{
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file2);
            StringBuilder sb = new StringBuilder();
            while (br.ready()){
                sb.append(br.readLine()+" ");
            }

            String[] parts = sb.toString().split(" ");
            //System.out.println(sb.toString());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                String word = parts[i];;
                if(word.length()>6){
                    result.append(word).append(" ");
                }
            }
            fw.write(result.toString().trim().replaceAll(" ",","));

            fr.close();
            br.close();
            fw.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }







    }


}
