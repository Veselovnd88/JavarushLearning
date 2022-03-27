package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WriteToFiles {

    public static void task(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileIn = br.readLine();
            String fileOut1 = br.readLine();
            String fileOut2 = br.readLine();

            FileWriter fw = new FileWriter(fileIn,true);
            FileReader fr1 = new FileReader(fileOut1);

            FileReader fr2 = new FileReader(fileOut2);
            int b;
            while((b=fr1.read())!=-1){
                fw.write(b);
            }
            while ((b=fr2.read())!=-1){
                fw.write(b);
            } fw.close();
            fr1.close();
            fr2.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void task2(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileIn = br.readLine();
            String fileOut = br.readLine();
           // String fileIn  = "src/my/learning/javarush/arrays/in.txt";
            //String fileOut = "src/my/learning/javarush/st2/out2.txt";
            BufferedReader br1 = new BufferedReader(new FileReader(fileIn));
            List<Integer> buff = new ArrayList<>();
            while (br1.ready()){
                buff.add(br1.read());
            }
            FileWriter fw = new FileWriter(fileIn);
            BufferedReader br2 = new BufferedReader(new FileReader(fileOut));
            int b;
            while((b=br2.read())!=-1){
                fw.write(b);
            }
            for (int c: buff) {
            //    System.out.println(c);
                fw.write(c);
            }

            fw.close();
            br2.close();
            br1.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
