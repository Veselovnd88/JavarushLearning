package my.learning.javarush.st3.tetris;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void testField() {
        final List<int[]> rowValueVariants = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    rowValueVariants.add(new int[]{i, j, k});
                }
            }
        }
        for (int[] first : rowValueVariants) {
            for (int[] second : rowValueVariants) {
                for (int[] third : rowValueVariants) {
                    test(new int[][]{first, second, third});
                    System.out.println("+++++\n");
                }
            }
        }

    }

    private static void test(int[][] matrix) {
        Field field = new Field(3, 3);
        field.setMatrix(matrix);


        System.out.println("Before");
        for (int[] row : field.getMatrix()) {

            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        field.removeFullLines();
        System.out.println("After");
        for (int[] row : field.getMatrix()) {

            System.out.println(Arrays.toString(row));
        }
    }

}
