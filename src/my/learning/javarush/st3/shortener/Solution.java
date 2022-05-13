package my.learning.javarush.st3.shortener;

import my.learning.javarush.st3.shortener.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
    StorageStrategy myStrategy = new HashMapStorageStrategy();
    testStrategy(myStrategy,10000);
    StorageStrategy myStrategy2 = new OurHashMapStorageStrategy();
    testStrategy(myStrategy2,10000);
    Entry e = new Entry(100,100l,"test",null);
        System.out.println(e.getKey());
    FileBucket fb = new FileBucket();
    fb.putEntry(e);
    Entry got = fb.getEntry();
    System.out.println(e.equals(got));

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> mySet = new HashSet<>();
        for(String s: strings){
            mySet.add(shortener.getId(s));
        } return mySet;
    }

    public  static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> mySet = new HashSet<>();
        for(Long l: keys){
            mySet.add(shortener.getString(l));
        } return mySet;
    }

    public static  void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> allStrings = new HashSet<>();
        for (int i=0; i<elementsNumber; i++){
            allStrings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Long start = new Date().getTime();
        Set<Long> ids = getIds(shortener,allStrings);
        Long finish = new Date().getTime();
        System.out.println("getIds отработал за "+ (finish-start)+ " мс");
        Long start2 = new Date().getTime();
        Set<String> string2 = getStrings(shortener,ids);
        Long finish2 = new Date().getTime();
        System.out.println("getStrings отработал за "+ (finish2-start2)+" мс");
        if(allStrings.size()==string2.size()){
            System.out.println("Тест пройден.");
        }
        else{
            System.out.println("Тест не пройден");
        }



    }
}
