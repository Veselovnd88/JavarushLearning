package my.learning.javarush.st3.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static Helper helper = new Helper();

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();

        Monkey monkey = new Monkey("Simka");

        WeakReference<Monkey> reference = new WeakReference<>(monkey);//вик референс удаляется при вызове сборщика мусора

        helper.callGC();

        monkey = null;

        helper.callGC();
        helper.consumeHeap();

        if (reference.get() == null)
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.out.println("GC called");
            System.gc();
            Thread.sleep(1000);
        }

        void consumeHeap() {
            try {
                List<task1> heap = new ArrayList<task1>(100000);
                while (!isFinalized) {
                    heap.add(new task1());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " s");
        }
    }
}
