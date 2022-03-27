package my.learning.javarush.st2;

import java.io.FileReader;

public class Whitespaces {
    public static void task(String[] args){
        String file = args[0];
        int countW=0;
        int countAll=0;
        try {
            FileReader fw = new FileReader(file);
            int b;
            while((b=fw.read())!=-1){
                if (b==32){
                    countW++;
                }
                countAll++;

            }
            //System.out.println(countAll);
            //System.out.println(countW);
            double result = (double) countW/countAll*100;
            System.out.printf("%.2f",result);
            fw.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
