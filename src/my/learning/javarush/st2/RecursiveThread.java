package my.learning.javarush.st2;

public class RecursiveThread {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void task() {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            this.start();
            ;
        }

        @Override
        public String toString() {
            return this.getName()+" created";
        }
        @Override
        public void run(){
            while (createdThreadCount<count){
                System.out.println(new GenerateThread());
            }
        }
    }
}
