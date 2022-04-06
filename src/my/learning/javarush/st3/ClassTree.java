package my.learning.javarush.st3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ClassTree {
    //"src/my/learning/javarush/st3"
    //"C:\Users\Nikolay\IdeaProjects\JavarushLearning\src\my\learning\javarush\st3\myfile.txt"
    public static void task(String[] args){
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newfile = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
       // if(FileUtils.isExist(newfile)){
           // newfile.delete();
       // }
       // FileUtils.renameFile(resultFileAbsolutePath,newfile);
        for(File f: path.listFiles()){
            System.out.println(f.getName());
        }

    }
    public static void dirs(File path){
        for(File f: path.listFiles()){
            if (f.isDirectory()){
                dirs(f);
            }
            else{
                if( f.length()<=50){
                    try{
                    FileInputStream fis = new FileInputStream(f);
                        FileOutputStream fos = new FileOutputStream(result)
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
