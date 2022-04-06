package my.learning.javarush.st2.bonustasks;

import java.util.Arrays;

public class Rectangles {

    public static void task() {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0}, // i Слева направо -
                {1, 1, 0, 0},//сверху вниз - j
                {1, 1, 0, 0},
                {1, 1, 0, 1}

        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count =0;

        for(int i=0; i<a.length; i++){
            for (int j=0; j<a[0].length; j++){
                if(a[i][j]==1){

                }

                }

            }

        return 0;
    }

}
