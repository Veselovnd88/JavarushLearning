package my.learning.javarush.st2.bonustasks;

import java.util.Arrays;

public class Rectangles {

    public static void task() {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 1}, // i Слева направо -
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
        System.out.println("count = " + count1 + ". Должно быть 3");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count =0;

        for(int i=0; i<a.length; i++){

            for (int j=0; j<a[0].length; j++){
                if(a[i][j]==1){
                    if(i<a.length-1 && j<a[0].length-1){
                        if(a[i][j+1]==0 && a[i+1][j]==0){
                        count++;}
                    }
                    else if( j== a[0].length-1 && i<a.length-1){
                        if(a[i+1][j]==0){
                            count++;
                        }
                    } else if(i==a.length-1 && j<a[0].length-1){
                        if(a[i][j+1]==0){
                            count++;
                        }

                    } else if(i==a.length-1 && j==a[0].length-1){
                        count++;
                    }

                }

                }

            }

        return count;
    }

}
