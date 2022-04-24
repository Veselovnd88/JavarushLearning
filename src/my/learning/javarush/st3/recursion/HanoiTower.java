package my.learning.javarush.st3.recursion;

import java.sql.SQLOutput;

public class HanoiTower {
    public static void task(){
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }
    public static void moveRing(char a, char b, char c, int numRings) {
        if(numRings==1){
            System.out.println("from "+a +" to "+b);
            return;
        }
        else{
            moveRing(a,b,c,numRings-1);
            System.out.println("from "+a +" to "+b);
            moveRing(c,a,b,numRings-1);
            return;
        }

    }
}
