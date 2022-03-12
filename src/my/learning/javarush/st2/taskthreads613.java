package my.learning.javarush.st2;

public class taskthreads613 {
    public volatile static int COUNT = 4;

    public static void task() throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            Thread t = new SleepingThread();
            t.join();

        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countdownIndex == 0) return;
                try{
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    System.out.println("Нить прервана");
                    break;
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
