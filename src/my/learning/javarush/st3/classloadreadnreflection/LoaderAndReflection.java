package my.learning.javarush.st3.classloadreadnreflection;

import my.learning.javarush.st2.serialization.FindErrorTask;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LoaderAndReflection {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public LoaderAndReflection(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        String name = LoaderAndReflection.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/my/learning/javarush/st3/classloadreadnreflection/data/second";
        System.out.println(name);
        LoaderAndReflection solution = new LoaderAndReflection(name);
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        //заполняет поле hiddenClasses


        ArrayList<File> clazzes = new ArrayList<>();//лист для всех файлов классов
        File path = new File(packageName);
        for(File f: path.listFiles()){//для каждого файла из директории
            if(f.isFile()&& f.getName().endsWith(".class")){// проверяет если файл и имеет окончание класс то добавили
                clazzes.add(f);
            }
            //System.out.println(clazzes);
        }
        //System.out.println(clazzes.size());
        myLoader myLoad = new myLoader();
        clazzes.forEach(x->{

            //System.out.println("Ищем класс по ссылке");
            //System.out.println(x.getAbsolutePath());
            Class<?> clazz = myLoad.findClass(x.getAbsolutePath());
            Class[] interfaces = clazz.getInterfaces();

            for( Class c: interfaces){
                System.out.println(c.getName());
                if(c==HiddenClass.class){
                    //System.out.println("сюда попадает?");
                    Constructor[] constructors = clazz.getConstructors();
                    for( Constructor constructor: constructors){
                        if(constructor.getParameters().length==0){
                            hiddenClasses.add(clazz);
                        }
                    }


                }
            }
        });
        System.out.println(hiddenClasses);
    }



    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class cl: hiddenClasses){
            if(cl.getSimpleName().toLowerCase(Locale.ROOT).startsWith(key.toLowerCase())){
                Constructor constructor = null;
                try {
                    constructor = cl.getConstructor(cl.getClass());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    HiddenClass hc = (HiddenClass) constructor.newInstance();
                    return hc;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
    public class myLoader extends ClassLoader{

        public myLoader(){
            super();
        }
        @Override
        public Class<?> findClass(String name) {
            try{
                byte[] bytes = fetchClassFS(name);
                Class<?> clazz = defineClass(null,bytes, 0, bytes.length);
                return clazz;
            } catch (IOException e) {
                e.printStackTrace();
            }return null;
        }
        private static byte[] fetchClassFS(String path) throws IOException {
            InputStream is = new FileInputStream(new File(path)); //входящий поток
            long length = new File(path).length();// длина файла
            if(length>Integer.MAX_VALUE){
                return null;// проверка на размер файла
            }
            byte[] result = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while(offset<result.length && (numRead=is.read(result, offset,result.length-offset))>=0){
                //пока офсет не вышел за пределы массива и
                //считали байты в массив начиная с офсета - количество - длина массива минус офсет
                offset+=numRead;
            }
            if (offset<result.length){
                throw new IOException("Файл не удалось считать полностью "+path);
            }
            is.close();
            return result;
        }
    }

}
