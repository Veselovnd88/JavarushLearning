package my.learning.javarush.st3.shortener.tests;

import my.learning.javarush.st3.shortener.Helper;
import my.learning.javarush.st3.shortener.Shortener;
import my.learning.javarush.st3.shortener.strategy.HashBiMapStorageStrategy;
import my.learning.javarush.st3.shortener.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    private long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startTimeStamp = new Date();
        for(String s: strings){
            ids.add(shortener.getId(s));
        }
        Date finishTimeStamp = new Date();
        return finishTimeStamp.getTime() - startTimeStamp.getTime();
    }

    private long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTimeStamp = new Date();
        for(Long l: ids){
            strings.add(shortener.getString(l));
        }
        Date finishTimeStamp = new Date();
        return finishTimeStamp.getTime() - startTimeStamp.getTime();
    }
    @Test
    public void testHashMapStorage(){
        Shortener sh1 = new Shortener(new HashMapStorageStrategy());
        Shortener sh2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for(int i=0; i<10000; i++){
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids = new HashSet<>();
        Long time1 = getTimeToGetIds(sh1,origStrings, ids);
        Long time2 = getTimeToGetIds(sh2,origStrings,ids);
        Assert.assertTrue(time1>time2);
        Set<String> strs = new HashSet<>();
        Long time3 = getTimeToGetStrings(sh1, ids, strs);
        Long time4 = getTimeToGetStrings(sh2,ids,strs);
        Assert.assertEquals(time3,time4,30);

    }

}
