package my.learning.javarush.st2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class ExTask {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void go() {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        } exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new ClassCastException());
        exceptions.add(new IOException());
        exceptions.add(new InterruptedIOException());
        exceptions.add(new InterruptedException());
        exceptions.add(new SecurityException());


    }
}
