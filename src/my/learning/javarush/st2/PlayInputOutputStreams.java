package my.learning.javarush.st2;

import my.learning.javarush.arrays.ArraysTasks;

import java.io.*;
import java.util.*;

public class PlayInputOutputStreams {

    public static void task(){
        oftenBytes();

    }
    public static void training(){
        try{
        FileInputStream fis = new FileInputStream("src/my/learning/javarush/arrays/in.txt");
        long sum = 0;
            while(fis.available()>0){
                int data = fis.read();
                sum+=data;
            }
        fis.close();
            System.out.println(sum);}
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }




    }

    public static void maxByte(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            int max = 0;
            while(fis.available()>0){
                int curr = fis.read();
                if(curr>max){
                    max = curr;
                }
            }fis.close();
            System.out.println(max);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void oftenBytes(){
        //src/my/learning/javarush/arrays/in.txt
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            while (fis.available()>0){
                count++;
                int bt = fis.read();
                if (hm.containsKey(bt)){
                    hm.put(bt, hm.get(bt)+1);
                }
                else {
                    hm.put(bt,1);
                }
            } int max=0;
            for (Map.Entry<Integer,Integer> en: hm.entrySet()){
                if (en.getValue()>max){
                    max = en.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> en :hm.entrySet()){
                if( en.getValue()==max){
                    System.out.print(en.getKey()+" ");
                }
            }


            fis.close();
            //System.out.println(l.size());
            //System.out.println(count);



        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
