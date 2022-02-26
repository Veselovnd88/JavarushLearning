package my.learning.javarush.arrays;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.Month;
public class JrushDriver {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};
        int x = Arrays.stream(data).min().getAsInt();
        for (int i = 0; i < data.length ; i++) {

        }
        System.out.println(x);
    }


    }

