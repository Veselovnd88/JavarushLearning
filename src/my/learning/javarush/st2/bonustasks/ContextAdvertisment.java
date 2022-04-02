package my.learning.javarush.st2.bonustasks;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContextAdvertisment {
    public static TestString testString = new TestString();
    public static void task(){
        PrintStream base = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(output);
        System.setOut(outputStream);
        testString.printSomething();
        System.setOut(base);
        String[] result = output.toString().split("\\n");
        for (int i = 0; i < result.length ; i++) {
            if(i!=0&&(i%2==0)){
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(result[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
