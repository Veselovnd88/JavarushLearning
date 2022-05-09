package my.learning.javarush.st3.multiMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMultiMap <K,V> extends HashMap<K,V> implements Serializable, Cloneable {
    private int repeatCount;
    private HashMap<K, List<V>> myMap;

    public MyMultiMap (int repeatCount){
        this.repeatCount = repeatCount;
        this.myMap = new HashMap<K,List<V>>();
    }
    @Override
    public V put(K key, V value) {
        V returnValue = null;
        if(myMap.containsKey(key)){
            returnValue = myMap.get(key).get(myMap.get(key).size()-1);
            //System.out.println(myMap.get(key));
            if(myMap.get(key).size()<repeatCount){
               List<V> tempList =  myMap.get(key);
               tempList.add(value);
               myMap.put(key,tempList);
                //return returnValue;
            }
            else if(myMap.get(key).size()==repeatCount){
                List<V> tempList = myMap.get(key);
                tempList.remove(0);
                tempList.add(value);
                myMap.put(key,tempList);
                //return returnValue;
            }
        }
        else{
            //V returnValue = null;
            List<V> myList = new ArrayList<>();
            myList.add(value);
            myMap.put(key, myList);
            //System.out.println(myMap);
            //return null;
        }
        return returnValue;
    }

    @Override
    public int size() {
        int count = 0;
        for(List<V> l: myMap.values()){
            count+=l.size();
        }
        return count;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : myMap.entrySet()) {
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
