package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InitTasks {
    public static int A;
    public static int B;
    static {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            A = Integer.parseInt(br.readLine());
            B = Integer.parseInt(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
        }
    public static final int MIN = min(A, B);

    public static void task() {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
