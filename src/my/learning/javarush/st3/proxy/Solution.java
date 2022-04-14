package my.learning.javarush.st3.proxy;

import my.learning.javarush.st3.ProxyTraining;

import java.lang.reflect.Proxy;

public class Solution {
    public static void task2(){

        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item

    }

    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }

    //Возвращаем любой объект с ограничением - только расширеннные от Item
    public <T extends Item> Item getProxy(Class<T> clazz, Class<?>...interfaces ){
        //передаются классы - первый тип, второй - массив любых других классов
        //первый аргумент  - класс для которого надо веррнуть прокси, остальное - список классов
        Class<?>[] ins = new Class<?>[interfaces.length+1];// массив из интерфейсов
        ins[0] = clazz;
        System.arraycopy(interfaces, 0, ins, 1, interfaces.length);//скорпировали массив в новый массив
        Object instance = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                interfaces,
                new ItemInvocationHandler());
        return (T) instance;
        /*передаем класс для которого будет прокси
        * */

    }
}
