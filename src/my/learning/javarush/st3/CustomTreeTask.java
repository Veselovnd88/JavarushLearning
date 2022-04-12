package my.learning.javarush.st3;

import java.util.List;

public class CustomTreeTask {
    public static void task(String[] args){
        List<String> list = new CustomTree();


        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        ((CustomTree) list).listTree.forEach(x->{
            System.out.println(x.elementName);
        });
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));
    }
}
