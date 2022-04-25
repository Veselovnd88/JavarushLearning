package my.learning.javarush.st3.references;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CacheTask {
    public static void main(String[] args) {
        SoftCache          cache = new SoftCache();
        Map<Long, AnyObject> map = new HashMap<>();
        List<AnyObject> list = new LinkedList<>();

        Runtime runtime = Runtime.getRuntime();
        long currentFree,total, used, max, size, priviosFree = runtime.freeMemory();
        String header = "Память(MB): используемая свободная    вся    максимальная";

        for (long i = 0; i < 15_000_000; i++) {
            cache.put(i, new AnyObject(i, null, null));    // попробуйте вместо добавления объектов сюда
//        map.put(i, new AnyObject(i, null, null));    // добавлять их сюда
//        list.add(  new AnyObject(i, null, null));    // или сюда
            if(i%25_000==0) {
                currentFree = runtime.freeMemory();
                total       = runtime.totalMemory();
                used        = total - currentFree;
                max         = runtime.maxMemory();
                size = i==0 ? 0 : used/i;

                if(currentFree>priviosFree || i==0)
                    System.out.printf("%s  Kолличество объектов: %,10d Средний размер объекта %4d байт %n"
                            ,header ,i ,size );

                System.out.printf("%19d %11d %9d %11d%n"
                        ,used>>20,currentFree>>20,total>>20,max>>20);

                priviosFree = currentFree;
            }
        }
}
}
