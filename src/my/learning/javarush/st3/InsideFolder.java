package my.learning.javarush.st3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;

public class InsideFolder {
    public static int fileCount=0;
    public static int dirCount=-1;
    public static long overallSize=0;

    public static void task() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        //System.out.println(file);
        if(!Files.isDirectory(Path.of(file))){
            System.out.println(Path.of(file).toString()+" - не папка");
        }
        else{


            Files.walkFileTree(Paths.get(file), new FileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    if (Files.isDirectory(file)){
                        System.out.println("я здесь");
                        dirCount++;
                    }
                    if(Files.isRegularFile(file)){
                        fileCount++;
                        long content = (long) Files.readAllBytes(file).length;
                        LongBinaryOperator binaryOperator
                                = (x, y) -> x + y;
                        overallSize+=content;
                    }



                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return null;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });







        }
        System.out.println("Всего папок - "+dirCount);
        System.out.println("Всего файлов - "+ fileCount);
        System.out.println("Общий размер - " + overallSize);
        br.close();
    }




}
