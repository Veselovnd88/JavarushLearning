package my.learning.javarush.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Collectionstraining {
    public static void reverse(ArrayList<Integer> list) {
        Collections.reverse(list);
    }

    public static void sort(ArrayList<Integer> list) {
    Collections.sort(list);
    }

    public static void rotate(ArrayList<Integer> list, int distance) {
Collections.rotate(list,distance);
    }

    public static void shuffle(ArrayList<Integer> list) {
    Collections.shuffle(list);
}
    public static Integer min(ArrayList<Integer> list) {
        return Collections.min(list);
    }

    public static Integer max(ArrayList<Integer> list) {

        return Collections.max(list);
    }

    public static int frequency(ArrayList<Integer> list, Integer element) {

        return Collections.frequency(list, element);
    }

    public static int binarySearch(ArrayList<Integer> list, Integer key) {
        Collections.sort(list);
        return Collections.binarySearch(list,key);
    }
    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        Collections.copy(destination,source);
    }

    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list,strings);
    }

    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list, oldValue,newValue);
    }
}
