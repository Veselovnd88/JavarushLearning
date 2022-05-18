package my.learning.javarush.st3.retrieverTasks.storage;

public interface Storage {
    void add(Object storedObject);

    Object get(long id);
}
