package my.learning.javarush.st2.parts;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GatherParts {

    public static void task(){
        /*
src/my/learning/javarush/st2/parts/evil.avi.part3
src/my/learning/javarush/st2/parts/evil.avi.part1
src/my/learning/javarush/st2/parts/evil.avi.part11
        *  */
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] first = o1.split("part");
                String[] second = o2.split("part");
                int f = Integer.parseInt(first[first.length-1]);
                int s = Integer.parseInt(second[second.length-1]);
                return f-s;
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        //FileOutputStream fos = new FileOutputStream("src/my/learning/javarush/st2/parts/evil.avi");
        String line;
        String output = null;
        while(true){
            line = br.readLine();
            if(line.equals("end")){
                break;
            }
            files.add(line);
            if (output == null) {
                int indexOfSuffix = line.lastIndexOf(".part");
                output = line.substring(0, indexOfSuffix);
            }}
            try(FileOutputStream fos = new FileOutputStream(output)) {
            files.forEach(x->{
                System.out.println("Пишу");
                try{

                    FileInputStream fis = new FileInputStream(x);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fos.write(buffer);
                    fis.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            });
        fos.close();
        br.close();
            System.out.println(files);

    }} catch (Exception e){
            e.printStackTrace();
        }
}
}
