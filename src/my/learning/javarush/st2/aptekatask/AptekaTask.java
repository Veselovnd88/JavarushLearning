package my.learning.javarush.st2.aptekatask;

import java.util.ArrayList;
import java.util.List;

public class AptekaTask {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void task() throws InterruptedException {
        Thread apteka = new Thread(new Apteka(), "Apteka");
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {

        @Override
        public void run() {
            while(!isStopped){
            drugsController.sell(getRandomDrug(), getRandomCount());
            waitAMoment();
            waitAMoment();
            waitAMoment();
        }
    }}

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped){
            drugsController.buy(getRandomDrug(),getRandomCount());
            waitAMoment();
        }
    }}

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (DrugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}