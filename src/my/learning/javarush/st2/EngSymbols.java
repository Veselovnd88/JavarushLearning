package my.learning.javarush.st2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EngSymbols {

    public static void task(String[] args){
        String file = args[0];
        Map<Integer, Integer> symbols = new TreeMap<>();
        try {
            FileReader fr = new FileReader(file);
            int b;
            while((b = fr.read())!=-1){
                if(symbols.containsKey(b)){
                    symbols.put(b,symbols.get(b)+1);
                }
                else{symbols.put(b,1);

                }
            }fr.close();
            symbols.forEach((x,y) ->{
                int a = x;
                char c = (char) a;
                System.out.println(c+" "+y);
            });
            //System.out.println(symbols);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
