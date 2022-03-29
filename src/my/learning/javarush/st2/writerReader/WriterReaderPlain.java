package my.learning.javarush.st2.writerReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterReaderPlain {

    public static void task(){
        List<Integer> l = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr = new FileReader(br.readLine());
            FileWriter fw = new FileWriter(br.readLine());
            while(fr.ready()){
                l.add(fr.read());
            }
            for(int i=0; i<l.size();i++){
                if((i+1)%2==0){
                    fw.write(l.get(i));
                }
            } br.close();
            fr.close();
            fw.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void epictask(){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr = new FileReader(br.readLine());
            while(fr.ready()){
                sb.append((char)fr.read());
            }
            String[] parts = sb.toString().split("[\\W\\s]");
            //System.out.println(parts);
            for(String c:parts){
                System.out.println(c);
                if(c.equals("world")){
                    count++;
                }
            } br.close();
            fr.close();
            System.out.println(count);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
