package my.learning.javarush.st3;

import my.learning.javarush.st2.bonustasks.Solution;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SearchHidden extends SimpleFileVisitor<Path> {

    public static void task(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final SearchHidden solution = new SearchHidden();
        Files.walkFileTree(Paths.get("C:\\_работа\\_ADZ-NAGANO\\Data Sheet"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

    if (file.getFileName().toString().endsWith(".zip")|| file.getFileName().toString().endsWith(".rar")){
        archived.add(file.toString());
    }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public  FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{

            failed.add(file.toString());

        return FileVisitResult.SKIP_SUBTREE;
    }

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
