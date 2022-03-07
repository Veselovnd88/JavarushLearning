package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodTasks {
    public static void task() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("exit")){
            try {
            if (line.contains(".")){
                print(Double.parseDouble(line));
            }
            else {
                int val = Integer.parseInt(line);
                if (val>0 &&val<128){
                    print(val);
                }
                else {
                    print(val);
                }}} catch (Exception e){
                print(line);

                }



            }


        }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
