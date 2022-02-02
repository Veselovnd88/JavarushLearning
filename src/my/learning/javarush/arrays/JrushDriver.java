package my.learning.javarush.arrays;


import java.util.Arrays;

public class JrushDriver {


    public static void main(String[] args) {
        Outer inner = new Outer();
        Outer.Inner my =  inner.new Inner();
        Outer.Nested nested = new Outer.Nested();

}
}
