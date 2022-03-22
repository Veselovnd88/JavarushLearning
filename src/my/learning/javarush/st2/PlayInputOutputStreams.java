package my.learning.javarush.st2;

import my.learning.javarush.arrays.ArraysTasks;

import java.io.*;
import java.util.ArrayList;

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
        ArrayList<Integer> l = new ArrayList<>(255);
        for(int i=0; i<l.size();i++){
            l.add(0);
        }
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            FileInputStream fis = new FileInputStream(file);
            while (fis.available()>0){
                int bt = fis.read();
                System.out.println(bt);
                if(l.get(bt)>0){
                    l.set(bt, l.get(bt+1));
                }
                else{l.set(bt, 0);};
            }fis.close();
            System.out.println(l.size());
            l.forEach(x-> System.out.println(x));
        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
