package my.learning.javarush.st2.planes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanesTask {
    public static void task() {

    }


    public static CanFly result;

    static {
        reset();
    }

    public static void reset() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if (line.equals("helicopter")){
                result = new Helicopter();
            }if (line.equals("plane")){
                int q = Integer.parseInt(br.readLine());
                result = new Plane(q);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
