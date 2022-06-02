package my.learning.javarush.st3.level9;
/*The number of possible ascents for 5 steps is: 13
The number of possible ascents for 10 steps is: 274
The number of possible ascents for 20 steps is: 121415
The number of possible ascents for 40 steps is: 23837527729
The number of possible ascents for 60 steps is: 4680045560037375
The number of possible ascents for 70 steps is: 2073693258389777176
* */


import java.util.Arrays;

public class stepsTask {

    public static void main(String[] args) {
        System.out.println(numberOfPossibleAscents(3));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }
        long[] memo = new long[n + 1];//создание массива из н+1 элементов
        Arrays.fill(memo, -1);//заполнили все элементы -1
        return numberOfPossibleAscents(n, memo);// вызываем функцию с двумя аргументами - переданное н и наш массив
    }

    private static long numberOfPossibleAscents(int n, long[] memo) {
        if (n < 0) {
            return 0;//если меньше 0 то возвращаем ноль
        } else if (n == 0) {// если н = 0 то возвращаем 1
            return 1;
        } else if (memo[n] > -1) {//если значение уже есть - то возвращаем его
            return memo[n];
        } else {//происходит
            memo[n] = numberOfPossibleAscents(n - 1, memo)
                    + numberOfPossibleAscents(n - 2, memo)
                    + numberOfPossibleAscents(n - 3, memo);


            //рекурсивное заполнение массива -значение вариантов попадания в текущую ячейку равно сумме значений в предыдущих трех
            return memo[n];
        }
    }
}
