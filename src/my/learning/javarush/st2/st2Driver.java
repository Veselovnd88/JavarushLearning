package my.learning.javarush.st2;

import my.learning.javarush.st2.planes.PlanesTask;

import java.math.BigDecimal;
import java.util.Scanner;

public class st2Driver {


    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
        System.out.println(FactorialTask.factorial(sc.nextInt()));
    }
}
