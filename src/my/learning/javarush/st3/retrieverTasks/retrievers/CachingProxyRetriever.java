package my.learning.javarush.st3.retrieverTasks.retrievers;

import my.learning.javarush.st3.retrieverTasks.cache.LRUCache;
import my.learning.javarush.st3.retrieverTasks.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever orig;
    private LRUCache cache;


    public CachingProxyRetriever(Storage storage){
        this.orig = new OriginalRetriever(storage);
        this.cache = new LRUCache(10);
    }

    @Override
    public Object retrieve(long id) {
        Object o = cache.find(id);
        if(o==null){
            Object retrieved = orig.retrieve(id);
            cache.set(id,retrieved);
            return retrieved;
        }
        else{
            return o;
        }
    }
}
