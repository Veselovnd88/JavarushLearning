package my.learning.javarush.st3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WorkWIthArchives {

    //"src/my/learning/javarush/st3/result.mp3"

    public static void  task(String[] args) throws IOException {

        File result = new File(args[0]);
        if(!result.exists()){
            result.createNewFile();
        }
        List<FileInputStream> fiss = new ArrayList<>();
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
        for(String s: zipparts){
            fiss.add(new FileInputStream(s));
        }
        try(
        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fiss)))){

        while(true){
            ZipEntry ze = zis.getNextEntry();
            if (ze==null){
                break;
            }
            try(OutputStream os = new BufferedOutputStream(new FileOutputStream(result))){
            final int buff = 1024;
            byte[] buffer = new byte[buff];
            for(int readbytes;(readbytes = zis.read(buffer,0,buff))>-1;){
                os.write(buffer,0,readbytes);
                os.flush();
            }
        }}
    }
    }
}
