package my.learning.javarush.arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CrDirs {

    public static void cr(){

    Scanner sc = new Scanner(System.in);
    Path path = Paths.get(sc.nextLine() + sc.nextLine());
    try {
        Files.createDirectory(path);
    } catch (IOException e){
        e.printStackTrace();
    }
}

}
