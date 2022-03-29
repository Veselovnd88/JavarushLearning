package my.learning.javarush.st2.writerReader;

import my.learning.javarush.st2.DebugTask;

import java.io.*;
import java.nio.Buffer;
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

    public static void task3(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
            BufferedWriter fw = new BufferedWriter(new FileWriter(br.readLine()));
            StringBuilder sb = new StringBuilder();
            while(fr.ready()){
                sb.append(fr.readLine());
            }
            //System.out.println(sb.toString());
            String[] parts = sb.toString().split(" ");
            StringBuilder sb2 = new StringBuilder();

            for (int i=0; i<parts.length;i++){
                //System.out.println(parts[i]);
//                StringBuilder sb2 = new StringBuilder();
                try{int b = Integer.parseInt(parts[i]);
                    //System.out.println("I am here");
                    if(i!=0){
                        sb2.append(" ");
                    }
                    sb2.append(b);

                } catch (NumberFormatException e){

                }
            }fw.write(sb2.toString());
            fw.close();
            fr.close();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void task4(){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
            BufferedWriter fw = new BufferedWriter(new FileWriter(br.readLine()));
            while(fr.ready()){
                sb.append(fr.readLine());
            }
            fw.write(sb.toString().replaceAll("[.]","!"));
            fw.close();
            fr.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void task5(){

                StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
            BufferedWriter fw = new BufferedWriter(new FileWriter(br.readLine()));
            while(fr.ready()){
                sb.append(fr.readLine());
            }
            fw.write(sb.toString().replaceAll("\\p{Punct}",""));
            fw.close();
            fr.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
