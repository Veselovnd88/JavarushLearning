package my.learning.javarush.st3.lists;
import java.lang.reflect.*;
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

                //System.out.println("реализуют Лист");
                //System.out.println(s.getName());
                if (Modifier.isPrivate(s.getModifiers()) && Modifier.isStatic(s.getModifiers())) {//проверка модификаторов

                    Method gt = s.getDeclaredMethod("get",int.class);
                    //System.out.println(gt.getName());
                    try {
                        Constructor[] constructors = s.getDeclaredConstructors();
                        for(Constructor c:constructors){
                            Parameter[] params = c.getParameters();
                            if(params.length==0){
                                c.setAccessible(true);
                             //   System.out.println("Констрруктор без параметров");
                                List inst = (List) c.newInstance();
                                inst.get(0);

                            }
                            //System.out.println(c.getName());
                        }

                    } catch (IndexOutOfBoundsException e) {
                        //e.getCause().toString().contains("IndexOutOfBoundsException");
                        System.out.println("вот мой класс"+ s.getName());
                        return  s;
                        //e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }}


            return null;
        }
    }