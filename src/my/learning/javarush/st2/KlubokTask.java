package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class KlubokTask {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void task(){
        Thread thr = threads.get(3);
        thr.start();

        try{
        Thread.sleep(1000);
        ((Thread4)thr).showWarning();

        }
        catch (InterruptedException e){

        }


    }
    public static class Thread1 extends Thread{
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
        }}

    }
    public static class Thread2 extends Thread{
        @Override
        public void run(){
            try{throw new InterruptedException();}
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
            System.out.println("Ура");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}

        }
}
    public static class Thread4 extends Thread implements Message{
        //static boolean flag = false;
        @Override
        public void showWarning(){
                this.interrupt();
                //flag = true;
        }
        @Override
        public void run(){
            while(!isInterrupted()){
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("stopped");
                    break;

                }
            }
        }
    }
    public static class Thread5 extends Thread{
        @Override
        public void run(){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int result = 0;
            try{
            while(!(line = br.readLine()).equals("N")){
                result+=Integer.parseInt(line);
            }
                System.out.println(result);}
            catch (IOException e){}
        }
    }

}
