package my.learning.javarush.st3.lists;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class findList {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class[] intfcs = Collections.class.getDeclaredClasses();// этот метод выдает все вложенные классы
        for (Class s : intfcs) {
            if (List.class.isAssignableFrom(s)) {//метод проверяет реализуют интерфейс илст или нет

                System.out.println("реализуют Лист");
                System.out.println(s.getName());
                if (Modifier.isPrivate(s.getModifiers()) && Modifier.isStatic(s.getModifiers())) {//проверка модификаторов
                    if (s.getDeclaredMethod("get", int.class) != null) {
                        Constructor cst = s.getConstructor();
                        cst.setAccessible(true);
                        try {
                            List obj = (List) cst.newInstance();
                            obj.get(0);


                        } catch (InvocationTargetException e) {
                            if (e.getCause().toString().contains("IndexOutOfBoundsException")) {
                                return s.getClass();
                            }
                        }
                        throw new RuntimeException();
                    }
                }
            }


            return null;
        }
    }
