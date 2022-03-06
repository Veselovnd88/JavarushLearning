package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NOD {
    public static void task() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        while ((x!=0)&& (y!=0)){
            if (x>y){
                x=x%y;
            }
            else {y = y%x;}
        }
        System.out.println(x+y);

    }
}
