package my.learning.javarush.st3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {


    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        boolean containsPart = true;
        boolean haveMinSize = true;
        boolean haveMaxSize = true;
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if(!file.getFileName().toString().contains(partOfName)){
            containsName = false;
        }
        if(!(new String(content).contains(partOfContent))){
            containsPart = false;
        }

        if (content.length < minSize){
            haveMinSize = false;
        }
        if(content.length>maxSize){
            haveMaxSize = false;
        }

        if(containsName&&containsPart&&haveMinSize&&haveMaxSize){
            foundFiles.add(file);
        }



        return super.visitFile(file, attrs);
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
