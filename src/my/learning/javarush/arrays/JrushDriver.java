package my.learning.javarush.arrays;


import java.util.ArrayList;
import java.util.Arrays;

public class JrushDriver {



    public static void main(String[] args) {
        CustomStringArrayList arrayList = new CustomStringArrayList();
        for(int i = 0; i < 25; i++) {
            arrayList.add("count" + i);
        }
    }

}

