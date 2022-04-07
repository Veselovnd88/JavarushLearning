package my.learning.javarush.st3;

import java.io.*;

public class ClassTree {
    //"src/my/learning/javarush/st3"
    //"C:\Users\Nikolay\IdeaProjects\JavarushLearning\src\my\learning\javarush\st3\myfile.txt"
    public static void task(String[] args){
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newfile = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
       if(FileUtils.isExist(newfile)){
           newfile.delete();
       }
       FileUtils.renameFile(resultFileAbsolutePath,newfile);
       dirs(path,newfile);
        //for(File f: path.listFiles()){
           // System.out.println(f.getName());
       // }


    }
    public static void dirs(File path, File result){
        for(File f: path.listFiles()){
            if (f.isDirectory()){
                dirs(f,result);
            }
            else{
                if( f.length()<=50){

                    if(f.getName().substring(f.getName().length()-4,f.getName().length()).equals(".txt")
                    && !f.getName().equals(result.getName())){
                        try(
                        FileReader fr = new FileReader(f);
                        FileWriter fw = new FileWriter(result,true);){
                            while(fr.ready()){
                                fw.write(fr.read());
                            }fw.write("\n");
                            fw.flush();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }


                }}
            }
        }

    }
}
