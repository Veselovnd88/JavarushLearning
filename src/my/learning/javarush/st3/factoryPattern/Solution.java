package my.learning.javarush.st3.factoryPattern;

import my.learning.javarush.st3.factoryPattern.male.MaleFactory;

public class Solution {

    public static void main(String[] args) {
        MaleFactory mf = new MaleFactory();
        Human one = mf.getPerson(99);
        Human two = mf.getPerson(4);
        Human three = mf.getPerson(15);
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }
}
