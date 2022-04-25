package my.learning.javarush.st3.references;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTrain {
    public static void main(String[] args) {
        MyClass mc = new MyClass(100,"hel");
        mc.setNumber(100);
        String name = null;
        System.out.println(mc.getNumber());

        try{
            Field field = mc.getClass().getDeclaredField("name");
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(mc,(String)"Hello");
            name = (String) field.get(mc);

            System.out.println(name);
            printData(mc);

        }
        catch (Exception e){
            e.printStackTrace();
        }

/*        MyClass mc2 = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());
            mc2 = (MyClass) clazz.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(mc2);*/

        MyClass mc3 = null;
        try {
            Class clazz = Class.forName(MyClass.class.getName());
            Class[] fields = {int.class, String.class};
            mc3 = (MyClass) clazz.getConstructor(fields).newInstance(1,"name2");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        printData(mc3);

    }

    public  static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

