package my.learning.javarush.st3.retrieverTasks.retrievers;

import my.learning.javarush.st3.retrieverTasks.storage.Storage;

public class OriginalRetriever implements Retriever {
    Storage storage;

    public OriginalRetriever(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Object retrieve(long id) {
        return storage.get(id);
    }
}