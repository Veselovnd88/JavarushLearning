package my.learning.javarush.arrays;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.Month;
public class JrushDriver {

    public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<>();
      Collections.addAll(list,"Hate", "World","Disaster");
      Stream<String> s = list.stream();
      List<String> l = s.filter(x->(x.length()<5)).collect(Collectors.toList());
      l.forEach(System.out::println);
    }


    }

