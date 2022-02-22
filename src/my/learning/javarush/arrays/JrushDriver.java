package my.learning.javarush.arrays;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;
import java.time.Month;
public class JrushDriver {

    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2022, Month.MARCH, 12);
        System.out.println(d.isAfter(LocalDate.now()));
    }


    }

