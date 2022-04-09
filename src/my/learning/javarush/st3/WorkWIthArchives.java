package my.learning.javarush.st3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipInputStream;

public class WorkWIthArchives {

    //"src/my/learning/javarush/st3/result.mp3"

    public static void  task(String[] args) throws FileNotFoundException {

        String result = args[0];
        //FileOutputStream fos = new FileOutputStream(result);
        List<String> zipparts = new ArrayList<>();
        int dot = args[1].lastIndexOf('.');

        String zipfile = args[1].substring(0,dot);
        System.out.println(zipfile);
        //System.out.println(zipfile);
        for(int i=1; i< args.length;i++){
            zipparts.add(args[i]);
        }
        //System.out.println(zipparts);
        Collections.sort(zipparts, (x, y) -> {
            int dot1 = x.lastIndexOf('.');
            int dot2 = y.lastIndexOf('.');
            return Integer.parseInt(x.substring(dot1+1,x.length()))-Integer.parseInt(y.substring(dot2+1,y.length()));
        });
        //System.out.println(zipparts);

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipfile));
        zipparts.forEach(x-> {

        });







    }



}
