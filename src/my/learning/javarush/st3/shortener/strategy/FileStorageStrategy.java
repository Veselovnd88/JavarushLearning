package my.learning.javarush.st3.shortener.strategy;

public class FileStorageStrategy implements StorageStrategy{



    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String string) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}
