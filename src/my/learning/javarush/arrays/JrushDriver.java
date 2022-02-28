package my.learning.javarush.arrays;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.Month;
public class JrushDriver {

    public static void main(String[] args) {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;


        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }

        @Override
        public User initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }
    }


    }

