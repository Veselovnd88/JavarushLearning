package my.learning.javarush.st2;

import my.learning.javarush.st2.planes.PlanesTask;
import my.learning.javarush.st2.planets.PlanetsTask;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.Scanner;

public class st2Driver {


    public static void main(String[] args) throws Exception {
        Test t = new Test();
        Thread thr = new Thread(t);
        Thread thr2 = new Thread(t);
        thr.start();
        thr.join();
        thr2.start();
    }
    public static class Test implements  Runnable{
        public void run(){
        for (int i = 0; i<20; i++){
            System.out.println(i);
        }
    }
}}

