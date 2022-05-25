/*
package my.learning.javarush.st3.shortener.tests;

import my.learning.javarush.st3.shortener.Helper;
import my.learning.javarush.st3.shortener.Shortener;
import my.learning.javarush.st3.shortener.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String one = Helper.generateRandomString();
        String two = Helper.generateRandomString();
        String three = new String(one);
        Long oneId = shortener.getId(one);
        Long twoId = shortener.getId(two);
        Long threeId = shortener.getId(three);
        Assert.assertNotEquals(oneId,twoId);
        Assert.assertNotEquals(threeId, twoId);
        Assert.assertEquals(oneId, threeId);
        String getOne = shortener.getString(oneId);
        String getTwo = shortener.getString(twoId);
        String getThree = shortener.getString(threeId);
        Assert.assertEquals(getOne,one);
        Assert.assertEquals(getTwo, two);
        Assert.assertEquals(getThree, three);
    }
    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy st = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy st = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy(){
        StorageStrategy st = new FileStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);

    }
    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy st = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);

    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy st = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy st = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(st);
        testStorage(shortener);
    }

}
*/
