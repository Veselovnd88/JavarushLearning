package my.learning.javarush.st3.ltomap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K,V extends Convertable<K>> Map<K,V> convert(List<V> list) {
//в начале - объявление переменных в сигнатуре
        Map<K,V> result = new HashMap();
        for(V c: list){
            K key = c.getKey();
            result.put(key,c);

        }
        return result;
    }
}

