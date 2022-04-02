package my.learning.javarush.st2.bonustasks;

import my.learning.javarush.st2.DebugTask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReversedStrings {

    public static void task(){
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try{
            FileReader fr = new FileReader(console.readLine());
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()){
                StringBuilder sb = new StringBuilder(br.readLine());
                System.out.println(sb.reverse().toString());
            }
            fr.close();
            br.close();
            console.close();



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
