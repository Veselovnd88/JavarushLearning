package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Salaries {

    public static void task(String[] args){
        Map<String, Double> map = new TreeMap<>();
        String file = args[0];
        try{
        FileReader fw = new FileReader(file);
        BufferedReader br = new BufferedReader(fw);

        while (br.ready()){
            String[] parts = br.readLine().split(" ");
            String name = parts[0];
            Double salary = Double.parseDouble(parts[1]);
            if (map.containsKey(name)){
                map.put(name,map.get(name)+salary);
            }
            else{
                map.put(name,salary);
            }
        }
        } catch (Exception e){
            e.printStackTrace();
        }
        map.forEach((x,y)-> System.out.println(x+" "+y));



    }

    public static void task2(String[] args){
        Map<String, Double> map = new TreeMap<>();
        String file = args[0];
        try{
            FileReader fw = new FileReader(file);
            BufferedReader br = new BufferedReader(fw);

            while (br.ready()){
                String[] parts = br.readLine().split(" ");
                String name = parts[0];
                Double salary = Double.parseDouble(parts[1]);
                if (map.containsKey(name)){
                    map.put(name,map.get(name)+salary);
                }
                else{
                    map.put(name,salary);
                }
            }fw.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        Double max = 0.0;
        for (Map.Entry<String, Double> en : map.entrySet()){
            if(en.getValue()>max){
                max  = en.getValue();
            }
        }
        for(Map.Entry<String,Double> en: map.entrySet()){
            if (en.getValue().equals(max)){
                System.out.println(en.getKey());
            }
        }



    }


}
