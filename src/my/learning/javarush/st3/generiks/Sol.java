package my.learning.javarush.st3.generiks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sol {



    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Sol.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Sol.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        //System.out.println(Sol.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Sol.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();

        List<File> correctFiles = new ArrayList<>();
        File path = new File(pathToAnimals);
        for(File f: path.listFiles()){
            if (f.isFile()&&f.getName().endsWith(".class")){
                correctFiles.add(f);
            }
        }
        correctFiles.forEach(x->{
            System.out.println(x.getAbsolutePath());
        });
        String classname = "/home/nikolay/IdeaProjects/JavarushLearning/out/production/JavarushLearning/my/learning/javarush/st3/generiks/data/Cat.class";
        Class clazz = null;




        return null;
    }



}
class ModuleLoader extends ClassLoader{
    private String path;
    public ModuleLoader(String path, ClassLoader parent){
        super(parent);
        this.path = path;
    }
    @Override
    public Class<?> findClass(String path){
        try{
            byte[] b = fetchClassFS(path);
        }
    }
    private static byte[] fetchClassFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));// создали считывающий поток
        long length = new File(path).length();// получили длину
        if(length> Integer.MAX_VALUE){
            return null;// проверка на размер
        }
        byte[] byteArr = new byte[(int) length];// байтовый массив
        int offset = 0;
        int numRead = 0;
        while(offset<byteArr.length
                && (numRead = is.read(byteArr,offset,byteArr.length-offset))>=0){
            offset+=numRead;
        }// весь файл считали в байтовый массив
        if(offset<byteArr.length){
            throw new IOException("Файл не удалось считать полностью "+path);
        }
        is.close();
        return byteArr;

    }
}

