package my.learning.javarush.st3.shortener.strategy;

import java.util.HashMap;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long,String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key,value);
    }

    @Override
    public Long getKey(String string) {

        for(Long k: data.keySet()){
            if(data.get(k).equals(string)){
                return k;
            }
        } return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
