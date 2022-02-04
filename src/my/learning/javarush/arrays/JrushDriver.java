package my.learning.javarush.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class JrushDriver {
    public static void main(String[] args) {

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

