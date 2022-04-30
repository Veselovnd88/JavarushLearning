package my.learning.javarush.st3.generiks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
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
            ModuleLoader loader = new ModuleLoader(x.getAbsolutePath());

            Class<?> clazz = loader.findClass(x.getAbsolutePath());

            Class<?>[] ints = clazz.getInterfaces(); // массив интерфейсорв
           // String pack = clazz.getPackageName();
           // String interfaceName = pack.substring(0, pack.length()-4)+"Animal";


            if(ints.length!=0) {
                for (Class<?> c : ints) {
                    if( c ==Animal.class){//проходим по массиву - если есть поддержка нужного интерфеса
                        //System.out.println(clazz.getName()+ " поддерживает интерфейс "+c.getName());
                        try{

                            Constructor[] constructors = clazz.getConstructors();//получаем конструкторы
                            for (Constructor<?> cst :constructors){
                                if(cst.getParameters().length==0){//если есть без параметров то создаем инстанс
                                    result.add( (Animal) clazz.newInstance()  );
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            //System.out.println(clazz.getName());


        });


        String classname = "/home/nikolay/IdeaProjects/JavarushLearning/out/production/JavarushLearning/my/learning/javarush/st3/generiks/data/Cat.class";
        String classname1 = "C:\\Users\\VeselovND\\git\\JavarushLearning\\src\\my\\learning\\javarush\\st3\\generiks\\data\\Cat.class";

        return result;
    }



}
class ModuleLoader extends ClassLoader{// создаем новый загрузчик наследуемся от Класс Лоадер
    private String path;
    public ModuleLoader(String path){
        super();
        this.path = path;
    }
    @Override
    public Class<?> findClass(String name){
        try{
            byte[] b = fetchClassFS(name);
            //System.out.println(b.length);
            return defineClass(null,b,0, b.length);// тут передаем в класснейм нулл т.к. не знаем точно какой класс нам надо вернуть
        }
        catch (IOException e) {
            e.printStackTrace();
        }// в итоге вернули дженерик класс
        return null;
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

    }// этот метод преобразуется в массив
    //байтов файл чтобы передаваеть его потом в метод определить класс
}

