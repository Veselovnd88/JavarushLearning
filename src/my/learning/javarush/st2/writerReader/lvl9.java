package my.learning.javarush.st2.writerReader;

import java.io.*;
import java.util.Locale;

public class lvl9 {
    public static TestString testString = new TestString();



    public static void task(){
        PrintStream base = System.out;// присвоил в переменную стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();// байтовый массив - стрим
        PrintStream output = new PrintStream(outputStream); //создал стрим который будет выводить байтовым массив
        System.setOut(output);//теперь будет выводиться в наш другой поток
        testString.printSomething();
        String result = outputStream.toString().toUpperCase(Locale.ROOT);
        System.setOut(base);
        System.out.println(result);




    }

    public static void task2(){
        PrintStream base = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputStream);
        System.setOut(output);
        testString.printSomething();
        String result = outputStream.toString().replaceAll("te","??");
        System.setOut(base);
        System.out.println(result);
    }
    public static void task3(){
        PrintStream base = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputStream);
        System.setOut(output);
        testString.printSomething();
        String result = outputStream.toString().replaceAll("[^0-9]","");
        System.setOut(base);
        System.out.println(result);
    }

    public static void task4(){
        PrintStream base = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputStream);
        System.setOut(output);
        testString.printSomething();
        String result = outputStream.toString().trim();
        String[] parts = result.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        if(parts[1].equals("+")){
            result +=" "+ (a+b);
        }
        else if(parts[1].equals("-")){
            result+=" "+ (a-b);
        }
        else if(parts[1].equals("*")){
            result+=" "+ (a*b);
        }
        System.setOut(base);
        System.out.println(result);

    }


    public static void task5(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileOutputStream fos =  new FileOutputStream(br.readLine());

            PrintStream base = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(outputStream);
            System.setOut(output);
            testString.printSomething();
            fos.write(outputStream.toByteArray());
            fos.close();
            br.close();
            System.setOut(base);
            System.out.println(outputStream.toString());
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
            //System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
            //System.out.println("3 + 6 = ");
        }
    }



}
