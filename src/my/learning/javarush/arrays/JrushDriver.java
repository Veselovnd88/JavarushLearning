package my.learning.javarush.arrays;


import java.util.Arrays;

public class JrushDriver {

    public static void main(String[] args) {
        UniversityGroup universityGroup = new UniversityGroup();
        universityGroup.exclude("Виталий Правдивый");
        universityGroup.students.forEach(System.out::println);

    }

}
