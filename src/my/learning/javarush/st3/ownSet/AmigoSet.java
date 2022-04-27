package my.learning.javarush.st3.ownSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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



    public void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();//сеарилизуется всё что есть по дефолу
        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));// сериализуется капасити
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));// сериализуется лоадфактор
        oos.writeInt(map.size());//сериализуется размер
        for(E e: map.keySet()){// сериализуется каждый элемент
            oos.writeObject(e);
        }

    }
    public void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        int size = ois.readInt();
        for (int i =0; i<size; i++){
            E e = (E) ois.readObject();
            map.put(e,PRESENT);
        }

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
    public Object clone() {
        AmigoSet<E> newSet = new AmigoSet<>();
        try{
        newSet.map = (HashMap<E, Object>) map.clone();}
        catch (Exception e){
            throw new InternalError();

        }
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
