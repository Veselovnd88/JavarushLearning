package my.learning.javarush.st3.generiks;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
Wildcards
*/

public class GenTask {

    public static <H> void add(List<? super H> destinationList, List<? extends H> sourceList) {
        //В сигнатуре объявляем переменные которые будем использовать, у нас D H - расширяет Д, S расширяет H
        //в параметрах - лист с элементами Д, лист с элеменами С

        ListIterator<? super H> destListIterator = destinationList.listIterator();
        ListIterator<? extends H> srcListIterator = sourceList.listIterator();
        for (int i = 0; i < sourceList.size(); i++) {
            destListIterator.add(srcListIterator.next());
        }
    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);

        /*
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e, com.javarush.test.level39.lesson08.task01.Solution$B@15c330aa]
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e]
         */
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}