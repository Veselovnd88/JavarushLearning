package my.learning.javarush.st2.adapters;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
src/my/learning/javarush/st2/out1.txt
 */
public class PersonScannerTask {
    public static void task() throws IOException {
        System.out.println(new PersonScannerAdapter(new Scanner(new FileReader("src/my/learning/javarush/st2/out1.txt"))).read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {
            String data = fileScanner.nextLine();
            String[] parts = data.split(" ");
            String fName = parts[1];
            String sName = parts[0];
            String tName = parts[2];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[5]),Integer.parseInt(parts[4])-1,Integer.parseInt(parts[3]));
            Date date = calendar.getTime();
            Person p = new Person(fName,tName, sName,date);

            return p;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }


}
