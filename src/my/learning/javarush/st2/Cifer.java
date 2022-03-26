package my.learning.javarush.st2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Cifer {

    public static void task(String key, String filename, String fileOutputName){
        try{
            FileInputStream fis = new FileInputStream(filename);
            FileOutputStream fos = new FileOutputStream(fileOutputName);

            if(key.equals("-e")) {
                while(fis.available()>0) {
                    fos.write(fis.read()+1);
                }
            }
            if(key.equals("-d")) {
                while(fis.available()>0) {
                    fos.write(fis.read()-1);

                }
            } fis.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        }
    }

