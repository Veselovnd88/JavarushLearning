package my.learning.javarush.arrays;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JrushDriver {


    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        outputStream.reset();
        byte[] arr = result.getBytes();
        for (int i = 0; i <arr.length/2; i++) {
            byte tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;

        }
        outputStream.write(arr);
        System.out.println(outputStream.toString());

    }

    public static void printSomething(String str) {
        stream.print(str);
    }

}

