package my.learning.javarush.st2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoundNumbers {
    public static void task(){
        try{
            List<Double> l = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file1 = br.readLine();
            String file2 =br.readLine();
            br.close();
            BufferedReader fileRead = new BufferedReader(new FileReader(file1));
            String line;

            while(!((line=fileRead.readLine()) ==null)){
                String[] substr = line.split(" ");
                for(String c:substr){
                    l.add(Double.parseDouble(c));
                }
            }
            FileWriter fw = new FileWriter(file2);
            for (int i = 0; i <l.size() ; i++) {
                int a = (int) Math.round(l.get(i));
                try {
                    StringBuilder sb = new StringBuilder();
                    if(i!=0){
                    sb.append(" ");}
                    sb.append(String.valueOf(a));
                    fw.write(sb.toString());
                    //System.out.println(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            };
            fw.close();
            br.close();
            fileRead.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
