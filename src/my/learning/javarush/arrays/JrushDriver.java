package my.learning.javarush.arrays;


import java.util.*;

public class JrushDriver {
    public static void main(String[] args) {
        StringsLinkedList stringsLinkedList = new StringsLinkedList();
        stringsLinkedList.add("1");
        stringsLinkedList.add("2");
        stringsLinkedList.add("3");
        stringsLinkedList.add("4");
        stringsLinkedList.add("5");
        stringsLinkedList.add("6");
        stringsLinkedList.add("7");
        stringsLinkedList.add("8");
        stringsLinkedList.add("9");
        //stringsLinkedList.printAll();
        System.out.println(stringsLinkedList.get(4)); // 5
    }


}

