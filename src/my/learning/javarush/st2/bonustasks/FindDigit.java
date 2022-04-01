package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FindDigit {


    public static void task(String[] args){
        String file1 = args[0];
        String file2 = args[1];
        try {
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            while(br.ready()){
                String line = br.readLine();
                String[] parts = line.split(" ");

                for(int i=0; i< parts.length; i++){
                    for(char c: parts[i].toCharArray()){
                        if (Character.isDigit(c)){
                            if(i!=0){
                                sb.append(" ");
                            }
                            sb.append(parts[i]);
                            break;
                        }
                    }
                }
            }
            fw.write(sb.toString());
            fw.close();
            br.close();
            System.out.println(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
