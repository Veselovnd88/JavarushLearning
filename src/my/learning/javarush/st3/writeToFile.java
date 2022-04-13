package my.learning.javarush.st3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class writeToFile {

        public static void task(String[] args) throws IOException {
        String filename = args[0];
        int pos = Integer.parseInt(args[1]);
        String text = args[2];


        RandomAccessFile raf = new RandomAccessFile(filename,"rw");
        if(pos<raf.length()){
            raf.seek(pos);

        }
        else{
            raf.seek(raf.length());
                    }
        raf.write(text.getBytes());





    }

        public static void task2(String[] args) throws IOException{
            String filename = args[0];
            int pos = Integer.parseInt(args[1]);
            String text = args[2];


            RandomAccessFile raf = new RandomAccessFile(filename,"rw");

            byte[] bytes = new byte[text.length()];
            raf.seek(pos);
            raf.read(bytes,0,text.length());
            String newString = new String(bytes);
            raf.seek(raf.length());
            if(newString.equals(text)){
                raf.write("true".getBytes());
            }
            else{
                raf.write("false".getBytes());
            }


        }
}
