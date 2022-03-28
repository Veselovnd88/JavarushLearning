package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SearchInsideFile {

    public static void task(String[] args){
        String id = args[0];
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();

            BufferedReader brFile = new BufferedReader(new FileReader(file));
            String line;
            while(!(((line = brFile.readLine())) ==null)){
                String[] parts = line.split(" ");
                if(parts[0].equals(id)){
                    System.out.println(line);
                }
            }


        br.close();
            brFile.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
