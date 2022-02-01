package my.learning.javarush.arrays;


import java.util.Arrays;

public class JrushDriver {


    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        Memory.executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));


}
}
