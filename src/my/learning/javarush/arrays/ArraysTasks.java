package my.learning.javarush.arrays;

import java.util.Arrays;

public class ArraysTasks {
    public static void reverseArray(int[] array){
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[array.length-i-1];
            array[array.length-i-1] = array[i];
            array[i] = temp;
            
        }
        System.out.println(Arrays.toString(array));
    }
}
