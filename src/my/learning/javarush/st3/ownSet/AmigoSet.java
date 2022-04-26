package my.learning.javarush.st3.ownSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet(){
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    public boolean add(E e){
        return map.put(e,PRESENT)==null;
    }


    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
    public boolean contains(Object o){
        return map.containsKey(o);
    }
    public void clear(){
        map.clear();
    }
    public boolean remove(Object o){
        if(map.containsKey(o)){
            map.remove(o);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AmigoSet<E> newSet = new AmigoSet<>();
        newSet.map = (HashMap<E, Object>) map.clone();
        return newSet;

    }

    @Override
    public Spliterator<E> spliterator() {
        return super.spliterator();
    }



    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return super.removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        super.forEach(action);
    }

    @Override
    public int size() {
        return map.size();
    }
}
