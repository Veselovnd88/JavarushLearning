package my.learning.javarush.st3;

import my.learning.javarush.st2.adapters.OneMoreAdapterTask;

import java.util.*;

public class generics {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList  (Object... elements) {
        ArrayList<T> list = new ArrayList<>();
        for(Object o:elements){
            list.add((T) o);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(Object... elements) {
        HashSet<T> hs = new HashSet<>();
        for (Object o: elements){
            hs.add((T) o);
        }
        return hs;
    }

    public static <K,V> HashMap<K,V> newHashMap(List keys, List values) {
        if (keys.size()!= values.size()){
            throw  new IllegalArgumentException();
        }
        else{
            HashMap<K,V> hm = new HashMap<>();
            for (int i=0; i<keys.size(); i++){
                hm.put((K) keys.get(i), (V) values.get(i));
            }return hm;
        }

    }
}
