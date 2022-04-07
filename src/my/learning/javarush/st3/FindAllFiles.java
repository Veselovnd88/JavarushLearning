package my.learning.javarush.st3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindAllFiles {

    public static void task() throws IOException {
        System.out.println(getFileTree("src/my/learning/javarush"));
    }


    public static List<String> getFileTree(String root) throws IOException {
        File path = new File(root);
        Queue<File> folders = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (File f: path.listFiles()){
            if (f.isDirectory()){
                folders.offer(f);

            } else result.add(f.getAbsolutePath());
        }
        while(folders.size()>0){
            File f = folders.poll();
            for (File fl: f.listFiles()){
                if (fl.isDirectory()){
                    folders.offer(fl);
                    System.out.println(folders.size());
                }
                else result.add(fl.getAbsolutePath());
            }

        }

        return result;

    }


}
