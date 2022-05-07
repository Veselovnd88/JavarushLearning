package my.learning.javarush.st3.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Сколько у человека потенциальных друзей?
*/

public class SocialNetwork {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        SocialNetwork solution = new SocialNetwork();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        /*если глубина 1, нужно пройти по всем индексам кроме заданного и выяснить у кого в друзьях есть этот индекс
        *в цикле, для каждого человека я проверяю дружит ли он с заданным и составляю сет
        *  */
        HashSet<Integer> mySet = new HashSet<>();

        //сформировали первую глубину - сет
        for (int i=0; i<humanRelationships.length;i++){
            if(i<index && index<humanRelationships.length&&humanRelationships[index][i]){
                System.out.println("Проверяем строку "+ i+" "+ Arrays.toString(humanRelationships[i]));
                mySet.add(i);
            }
            else if( i>index && humanRelationships[i][index]){
                System.out.println("Проверяем строку "+ i+" "+ Arrays.toString(humanRelationships[i]));
                mySet.add(i);
            }
        }
        if (deep<=1){
            //System.out.println(mySet);
            return mySet;
        }
        else {

            for(Object i: mySet.toArray()){
                mySet.addAll(getAllFriendsAndPotentialFriends((Integer) i, deep-1));}
            }
        mySet.remove(index);
        return mySet;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            //идем по всей матрице, если i < index ( список меньше чем тот у которого удаляем
            //второе условие - проверка на то что меньше длины вообще всего массива и [index][i] true - то делаем
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                //иначе первое условие чтобы i не было равно индексу, и дальше проверяем элемент на тру
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        /*номер строки - человек с Которым дружат, столбец - сам человек
        поэтому диагональ всегда в тру( дружит сам с собой, индекс 0-0, индекс 1 -1 и тд

        * */
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                // я беру например четвертый, и начинаю проверять всех его друзей,
                //у него друзья 0, 1 и 3.
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}
