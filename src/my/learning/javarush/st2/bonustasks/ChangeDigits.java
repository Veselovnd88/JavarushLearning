package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ChangeDigits {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2, "два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5, "пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");

    }
    public static void task(){

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try{
            FileReader fr = new FileReader(console.readLine());
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            while (br.ready()){
                sb.append(br.readLine().replaceAll("[\\n\\r]"," "));
            }
            String result = sb.toString();
            for(Map.Entry<Integer,String> en: map.entrySet()){
                //System.out.println(en.getKey());
                result = result.replaceAll("\\b"+en.getKey().toString()+"\\b",en.getValue());
            }
            System.out.println(result);
            console.close();
            br.close();
            fr.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }


}
