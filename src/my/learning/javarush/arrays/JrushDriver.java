package my.learning.javarush.arrays;


import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.ZoneId;

public class JrushDriver {
    public static void main(String[] args) {

        LocalDate today =  LocalDate.of(2021,3,22);
        LocalDate day = LocalDate.ofEpochDay(18517);
        System.out.println(day);
    }



}

