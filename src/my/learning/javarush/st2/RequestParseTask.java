package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestParseTask {
    public static void task() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
                //reader.readLine();
        int ind1  = url.indexOf("?");
        int ind2 = url.indexOf("=");
        int ind3 = url.indexOf("&");
        while (ind3!=-1){
            System.out.print(url.substring(ind1+1,ind2)+" ");
            String part = url.substring(ind3+1);
            //System.out.print(part+" ");
            ind1 = 0;
            ind2 = part.indexOf("=");
            System.out.print(part.substring(ind1, ind2));
            ind3 = part.indexOf("&");




        }
        System.out.println();
        int indObj = url.indexOf("obj");

        if (indObj!=-1){
            int indD = url.indexOf("&");
            String part = url.substring(indObj+4,indD);
            try{
                double d = Double.parseDouble(part);
                alert(d);

            } catch (NumberFormatException e){
                alert(part);
            }

        }



    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
