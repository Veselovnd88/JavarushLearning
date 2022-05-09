package my.learning.javarush.st3.multiMap;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyMultiMap <K,V> extends HashMap<K,V> implements Serializable, Cloneable {
    private int repeatCount;
    private HashMap<K, List<V>> map;

    public MyMultiMap (int repeatCount){
        this.repeatCount = repeatCount;
        this.map = new HashMap<K,List<V>>();
    }
    @Override
    public V put(K key, V value) {
        V returnValue = null;
        if(map.containsKey(key)){
            returnValue = map.get(key).get(map.get(key).size()-1);
            //System.out.println(myMap.get(key));
            if(map.get(key).size()<repeatCount){
               List<V> tempList =  map.get(key);
               tempList.add(value);
               map.put(key,tempList);
                //return returnValue;
            }
            else if(map.get(key).size()==repeatCount){
                List<V> tempList = map.get(key);
                tempList.remove(0);
                tempList.add(value);
                map.put(key,tempList);
                //return returnValue;
            }
        }
        else{
            //V returnValue = null;
            List<V> myList = new ArrayList<>();
            myList.add(value);
            map.put(key, myList);
            //System.out.println(myMap);
            //return null;
        }
        return returnValue;
    }


    @Override
    public V remove(Object key) {
        V returnValue = null;
        if( map.get(key)==null){
            returnValue =null;
        }
        else {
            List<V> tempList = map.get(key);
            returnValue = tempList.get(0);
            tempList.remove(0);
            if(tempList.size()==0){
                map.remove(key);
                return returnValue;
            }
            map.put((K) key,tempList);
        }
        return returnValue;
    }
    @Override
    public Set<K> keySet() {
        return map.keySet();
    }
    @Override
    public Collection<V> values() {
        List<V> allVals = new ArrayList<>();

        map.keySet().forEach(x->{
            map.get(x).forEach(v->{allVals.add(v);
            });
            });

        return allVals;
    }
    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }
    @Override
    public boolean containsValue(Object value) {
        AtomicBoolean bool = new AtomicBoolean(false);
        map.keySet().forEach(x->{
            if(map.get(x).contains(value)){
                bool.set(true);
            }
        });
        return bool.get();
    }

    @Override
    public int size() {
        int count = 0;
        for(List<V> l: map.values()){
            count+=l.size();
        }
        return count;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }


}
