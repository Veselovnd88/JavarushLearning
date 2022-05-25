/*
package my.learning.javarush.st3.iterators;

import my.learning.javarush.st3.shortener.Solution;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

*/
/*
Круговой итератор
*//*


public class RoundIter<T> extends ArrayList<T> {

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public static void main(String[] args) {
        RoundIter<Integer> list = new RoundIter<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        private Iterator<T> iter = RoundIter.super.iterator();
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public T next() {
            if(iter.hasNext()==false){
                iter = RoundIter.super.iterator();
                return iter.next();
            }
            else{
                return iter.next();
            }
        }

        @Override
        public void remove() {
            RoundIter.super.iterator().remove();
        }
    }
}*/
